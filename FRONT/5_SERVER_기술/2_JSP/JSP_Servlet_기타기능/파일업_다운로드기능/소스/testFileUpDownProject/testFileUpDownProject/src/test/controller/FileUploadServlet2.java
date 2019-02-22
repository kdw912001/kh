package test.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet2
 */
@WebServlet("/fileup2")
public class FileUploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// commons-fileupload.jar 라이브러리 사용한 경우
		//한글 파일명이 깨지지 않도록 인코딩 맞춰줌
		request.setCharacterEncoding("utf-8");
		
		//전송 가능한 파일 하나의 용량 지정 : 10메가바이트로 할 경우
		long fileLimit = 10 * 1024 * 1024;
		//한번에 전송가능한 총용량 지정 : 100메가 바이트로 할 경우
		long requestLimit = 100 * 1024 * 1024;
		
		//전송에 multipart 설정 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart){
			RequestDispatcher errorPage = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", "multipart 속성 설정이 되지 않았습니다.");
			errorPage.forward(request, response);
		}
		
		//메모리에 기록할 영역의 크기 지정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024);
		
		//업로드된 파일의 저장 위치 지정
		//1. 웹 컨테이너 안의 로딩된 프로젝트내의 폴더에 저장할 경우
		//String savePath = request.getSession().getServletContext().getRealPath("/uploadFiles2/");
		//2. 임의의 위치로 지정하는 경우
		String savePath = "E:\\오전반_수업자료\\workspace\\testFileUpDownProject\\web\\uploadFiles2";
		//저장할 폴더를 File 객체로 만듦 >> 폴더 등록
		File saveDir = new File(savePath);
		factory.setRepository(saveDir);
		
		//파일 업로드 핸들러 생성
		ServletFileUpload uploadHandler = new ServletFileUpload(factory);
		//핸들러에 읽을 제한 총용량 설정
		uploadHandler.setFileSizeMax(requestLimit);
		
		try {
			//전송된 파일정보를 추출함
			List<FileItem> files = uploadHandler.parseRequest(request);
			//전송된 파일들을 하나씩 꺼내서 저장함
			for(int i = 0; i < files.size(); i++){
				FileItem item = files.get(i);
				//폼에서 전송된 파일 정보가 맞는지 확인하고 용량 초과 체크함
				if(!item.isFormField()){
					//item 을 File 객체로 만듦
					File originalFile = new File(saveDir + "\\" + item.getName());
					//전송된 파일의 용량
					long fileSize = item.getSize();
					
					//용량 초과 검사
					if(originalFile.getName() != null && !originalFile.getName().equals("")){
						if(fileLimit < fileSize){ //전송 용량 초과시
							RequestDispatcher errorPage = request.getRequestDispatcher("error.jsp");
							request.setAttribute("message", "한번에 전송할 파일용량 10Mbyte 를 초과하였습니다.");
							errorPage.forward(request, response);
						}else{
							//저장 위치에 파일 기록 저장함
							item.write(originalFile);
							//'년월일시분초'로 파일명 변경 처리함
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							String newFileName = sdf.format(new java.sql.Date(System.currentTimeMillis()))
									+ "." + originalFile.getName().substring(originalFile.getName().lastIndexOf(".") + 1);
							File newFile = new File(saveDir + "\\" + newFileName);
							originalFile.renameTo(newFile);
						}
					}
				}
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
