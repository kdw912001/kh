package board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

import board.model.service.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/binsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 원글 등록 처리용 컨트롤러
		
		//enctype="multipart/form-data" 로 전송되었는지 확인
		RequestDispatcher view = null;
		if(!ServletFileUpload.isMultipartContent(request)) {
			view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", "form의 enctype 속성 사용 안 되었음.");
			view.forward(request, response);
		}
		
		//업로드할 파일의 용량 제한 : 10Mbyte 로 제한한다면
		int maxSize = 1024 * 1024 * 10;
		
		//파일이 저장될 폴더 지정 : 
		//content directory 안에 파일저장폴더를 정한 경우
		//현재 웹 컨테이너에서 구동중인 웹 에플리케이션의 
		//루트 폴더에 대한 경로 알아냄
		String root = request.getSession().getServletContext().getRealPath("/");
		//업로드되는 파일의 저장 폴더를 루트와 연결함
		String savePath = root + "files/board";
		
		//request 를 MultipartRequest 객체로 변환함
		MultipartRequest mrequest = new MultipartRequest(
				request, savePath, maxSize, "UTF-8", 
				new DefaultFileRenamePolicy());
		
		//전송 온 값 꺼내서 객체에 저장
		Board board = new Board();
		
		board.setBoardTitle(mrequest.getParameter("btitle"));
		board.setBoardWriter(mrequest.getParameter("bwriter"));
		board.setBoardContent(mrequest.getParameter("bcontent"));
		
		//전송온 파일의 파일명만 추출하고, 이름바꾸기 처리
		String originalFileName = mrequest.getFilesystemName("bupfile");
		
		//전송온 파일이 있을 때만 이름바꾸기 진행함
		if(originalFileName != null) {
			//바꿀 파일명 만들기
			//"년월일시분초.확장자"
			SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyyMMddHHmmss");
			String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
					+ "." + originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			
			//java.io.File 객체의 renameTo() 메소드 사용
			File originFile = new File(savePath + "\\" + originalFileName);
			File renameFile = new File(savePath + "\\" + renameFileName);
			
			if(!originFile.renameTo(renameFile)) {
				//파일명 직접 바꾸기함
				//원본 파일의 내용 읽어서, 리네임 파일에 복사 기록하기
				//원본 파일 삭제함
				int read = -1;
				byte[] buf = new byte[1024];
				
				FileInputStream fin = 
						new FileInputStream(originFile);
				FileOutputStream fout = 
						new FileOutputStream(renameFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1) {
					fout.write(buf, 0, read);
				}
				
				fin.close();
				fout.close();
				originFile.delete();
			}  //renameTo
			
			board.setBoardOriginalFileName(originalFileName);
			board.setBoardRenameFileName(renameFileName);
		} //첨부파일 있을 때
		
		//서비스모델로 객체 전달하고 결과받기
		int result = new BoardService().insertBoard(board);
		
		if(result > 0) {
			//글 등록이 성공하면, 게시글 목록보기가 실행되게 함
			//목록에 추가된 원글이 보여져야 됨
			response.sendRedirect("/second/blist?page=1");
		}else {
			view = request.getRequestDispatcher("views/board/boardError.jsp");
			request.setAttribute("message", "개시글 원글 등록 실패!");
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
