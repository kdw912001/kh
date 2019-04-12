package notice.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet("/nupdate")
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파일 업로드 기능이 포함된 공지글 수정 처리용 컨트롤러

		// 1. enctype="multipart/form-data" 로 전송왔는지 확인
		RequestDispatcher view = null;
		if (!ServletFileUpload.isMultipartContent(request)) {
			// form 태그에 enctype 속성이 없다면
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", "form 태그에 enctype 속성이 설정되지 않았습니다.");
			view.forward(request, response);
		}

		// 2. 업로드할 파일의 용량 설정 : 10Mbyte 로 제한한다면
		int maxSize = 1024 * 1024 * 10;

		// 3. 업로드할 파일의 저장 폴더 지정
		// 저장 폴더가 현재 구동중인 웹컨테이너(WAS: 톰켓)에서
		// 실행중인 웹애플리케이션 안에 있는 폴더일 경우
		// 루트 경로 알아냄
		String root = request.getSession().getServletContext().getRealPath("/");
		// System.out.println("root : " + root);
		// 업로드되는 파일이 저장되는 폴더명과 루트를 연결함
		String savePath = root + "files/notice";
		// System.out.println("savePath : " + savePath);

		// 웹서버 컴퓨터의 폴더일 경우
		// String savePath = "c:\\webapp\\files\\notice";

		// 4. cos.jar 라이브러리를 사용할 경우
		// MultipartRequest 객체를 생성함
		// 객체 생성과 동시에 자동 파일이 업로드 됨 : 지정한 폴더에 자동 저장됨.
		// request 객체가 MultipartRequest 객체로 바뀜
		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		// 전송온 값 꺼내서, Notice 객체에 저장하기
		Notice notice = new Notice();
		// System.out.println(request.getParameter("title"));
		notice.setNoticeNo(Integer.parseInt(mrequest.getParameter("no")));
		notice.setNoticeTitle(mrequest.getParameter("title"));
		notice.setNoticeWriter(mrequest.getParameter("writer"));
		notice.setNoticeContent(mrequest.getParameter("content"));
		// 전송온 파일의 이름 추출
		String originalFileName = mrequest.getFilesystemName("upfile");
		
		//첨부파일이 변경되었다면
		if(originalFileName != null) {		
			notice.setOriginalFilePath(originalFileName);

			// 파일명 rename 처리 진행
			// 새로운 파일명 만들기 : "년월일시분초.확장자"
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			Date currentTime = new Date(System.currentTimeMillis());
			String renameFileName = sdf.format(currentTime) + "."
					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			// System.out.println(renameFileName);

			// java.io.File 의 renameTo() 사용함
			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);

			// 파일 이름바꾸기 실행함
			// 이름바꾸기가 실패할 경우에는 직접 바꾸기 처리함
			// 직접 바꾸기는 원본 파일에 대한 복사본 파일을 만들고 원본 삭제함
			if (!originFile.renameTo(renameFile)) {
				// renameTo() 가 실패했을 때
				int read = -1;
				byte[] buf = new byte[1024];
				// 한번에 읽을 배열크기 지정

				// 원본파일을 읽기 위한 입력스트림 생성
				FileInputStream fin = new FileInputStream(originFile);
				// 읽은 내용 기록할 복사본 파일에 대한 출력스트림 생성
				FileOutputStream fout = new FileOutputStream(renameFile);

				// 원본 읽어서 복사본에 기록 처리
				while ((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}

				// 스트림 반납
				fin.close();
				fout.close();

				// 원본 파일 삭제
				originFile.delete();				
			} // rename if

			notice.setRenameFilePath(renameFileName);
		
			//전에 기록된 파일은 삭제 처리함
			if(!mrequest.getParameter("ofile").equals(notice.getOriginalFilePath()))
				new File(savePath + "\\" + mrequest.getParameter("rfile")).delete();
		
		}else { // 첨부 파일이 변경되지 않았을 때
			notice.setOriginalFilePath(mrequest.getParameter("ofile"));
			notice.setRenameFilePath(mrequest.getParameter("rfile"));
		}
		
		// 서비스모델로 notice 객체 전달하고 결과 받기
		int result = new NoticeService().updateNotice(notice);

		// 받은 결과를 가지고 성공/실패 뷰 선택 내보내기
		if (result > 0) {
			// 공지글 수정 성공시에는 공지글 상세보기 출력
			response.sendRedirect("/second/ndetail?no=" + notice.getNoticeNo());
		} else {
			view = request.getRequestDispatcher("views/notice/noticeError.jsp");
			request.setAttribute("message", 
					notice.getNoticeNo() + "번 공지글 수정 실패!");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
