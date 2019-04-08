package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.vo.SendAdmitEmail;

/**
 * Servlet implementation class AdmitEnrollMemberServlet
 */
@WebServlet("/admitmember")
public class AdmitEnrollMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmitEnrollMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 인증메일 처리용 컨트롤러
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String host = "smtp.naver.com";
		final String password = "Wheerang)615";
		int port = 587;
		
		URLDecoder.decode("urlcontext", "UTF-8");
		
		String number = request.getParameter("number");
		String email = request.getParameter("email");
		
		System.out.println(number + " !!! " + email);
		int idx = email.indexOf("@");
		
	Properties prop = new Properties();
	System.out.println(idx);
	System.out.println(String.valueOf(idx));
	prop.put("mail.smtp.host", host);
	prop.put("mail.smtp.port", port);
	prop.put("mail.smtp.auth", "true");
	prop.put("mail.mime.charset", "utf-8");
	prop.put("mail.smpt.ssl.enable", "true");
	prop.put("mail.smtp.ssl.trust", host);
	
	Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(email.substring(0,idx), password);
		}
	});
	session.setDebug(true);
	String value = null;
	try {
		StringBuffer buffer = new StringBuffer();
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(/*member.getEmail())*/));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		
		msg.setSubject("[doghouse]회원가입 인증 메일입니다.");
		
		String admitNum = new SendAdmitEmail().sendAdmitNumber();
		
		byte[] anon = "회원가입 인증번호입니다! welcome!".getBytes();
		buffer.append(anon);
		buffer.append(admitNum);
		msg.setText(buffer.toString()); //잘 됨.
		
		if(number.equals(admitNum)) {
			Transport.send(msg);
			System.out.println("The admitNum sent successfully...");
			value = "ok";
			out.print(value);
			/*out.println("<script>alert('인증에 성공하였습니다.');</script>");*/
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		/*out.println("<script>alert('인증번호를 잘못입력하셨습니다.');</script>");*/
		value = "dup";
		out.print(value);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
