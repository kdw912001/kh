package org.kh.first.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//일반 클래스가 뷰리졸버에 의해 실행되려면
//반드시 스프링이 제공하는 AbstractView 를 상속받은
//후손 클래스여야 함
@Component("filedown")
public class FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 파일 다운로드 처리 코드 작성함
		//컨트롤러에서 뷰리졸버로 리턴한 모델 정보가 
		//자동으로 전달되었음.
		/*System.out.println("downfile : " + 
				((File)model.get("downFile")).getName());*/
		
		File downFile = (File)model.get("downFile");
		//한글 파일명 글자깨짐 방지용 인코딩 처리
		String fileName = downFile.getName();
		
		response.setContentType("text/plain; charset=utf-8");
		response.addHeader("Content-Disposition", 
				"attachment; filename=\"" + 
				new String(fileName.getBytes("utf-8"), "ISO-8859-1")
				+ "\"");
		response.setContentLength((int)downFile.length());
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(downFile);
			FileCopyUtils.copy(fin, out);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fin != null) {
				try {
					fin.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		out.flush();
		out.close();
		
	}

}







