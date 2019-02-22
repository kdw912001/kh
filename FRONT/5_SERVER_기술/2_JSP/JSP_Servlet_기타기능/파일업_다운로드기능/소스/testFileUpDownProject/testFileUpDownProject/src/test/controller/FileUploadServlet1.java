package test.controller;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadServlet1
 */
@WebServlet("/fileup1")
public class FileUploadServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cos.jar 라이브러리를 이용한 파일업로드 처리용 컨트롤러
		
		//파일명이 한글일 경우, 인코딩 처리함
		request.setCharacterEncoding("utf-8");
		
		//전송 파일에 용량 제한을 두고 싶으면 정함 : 10 메가바이트로 할 경우
		int sizeLimit = 1024 * 1024 * 10;
		
		//전송 방식에 multipart 설정을 했는지 검사
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			RequestDispatcher errorPage = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", "multipart 설정을 하지 않았습니다.");
			errorPage.forward(request, response);
		}
		
		//업로드된 파일의 저장 위치 지정
		//1. 웹 컨테이너 내에 저장 위치를 지정할 경우
		//String savePath = request.getSession().getServletContext().getRealPath("/uploadFiles/");
		//2. 임의로 파일 저장 폴더를 만들고, 위치를 지정할 경우
		String savePath = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles";
		//System.out.println(savePath);
		
		//전송받을 파일명 저장용 변수
		String originalFileName = null;
		//실제 저장할 때 사용할 파일명 저장용 변수
		String renameFileName = null;
		
		//업로드한 날짜와 시간을 파일명으로 사용할 경우
		//시스템으로 부터 현재 날짜와 시간 정보를 얻어옴
		long currentTime = System.currentTimeMillis();
		//파일명으로 사용할 날짜/시간에 대한 포맷 설정
		SimpleDateFormat formatFileName = new SimpleDateFormat("yyyyMMddHHmmss");
		
		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit,
					"utf-8", new DefaultFileRenamePolicy());
			originalFileName = multi.getFilesystemName("file");
			//System.out.println(originalFileName);
			//바꿀 파일명 만들기
			renameFileName = formatFileName.format(new java.sql.Date(currentTime)) + "."
					+ originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			//기록 저장된 파일명 바꾸기 : 저장된 파일을 File 객체로 만듦
			File saveFile = new File(savePath + "\\" + originalFileName);
			//만약, 이름바꾸기가 실패했을 경우 직접 강제로 바꿈
			//바꿀 이름에 대한 파일을 만들고, 원본 파일을 복사하고 나서, 원본은 삭제함
			File newFile = new File(savePath + "\\" + renameFileName);
			
			if(!saveFile.renameTo(newFile)){
				//파일 읽기용 변수
				int read = 0;
				//한번에 읽을 크기와 값 담을 배열 지정
				byte[] buf = new byte[1024];
				
				//파일 입력용 스트림
				FileInputStream fin = new FileInputStream(saveFile);
				FileOutputStream fout = new FileOutputStream(newFile);
				
				while((read = fin.read(buf, 0, buf.length)) != -1){
					fout.write(buf);
				}
				
				fin.close();
				fout.close();
				saveFile.delete();  //원본 삭제함
			}
		} catch (Exception e) {
			e.printStackTrace();
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
