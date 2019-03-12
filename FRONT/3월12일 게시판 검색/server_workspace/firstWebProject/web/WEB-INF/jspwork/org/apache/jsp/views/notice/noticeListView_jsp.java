/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2019-03-12 09:40:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import notice.model.vo.*;
import java.util.*;
import member.model.vo.Member;

public final class noticeListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/notice/../common/header.jsp", Long.valueOf(1552035300000L));
    _jspx_dependants.put("/views/notice/../common/footer.jsp", Long.valueOf(1551698658000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("notice.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"noticeError.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");

	HashMap<Integer, Notice> map = 
		(HashMap<Integer, Notice>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");

	/* Collection<Notice> values = map.values();
	ArrayList<Notice> list = new ArrayList<Notice>(values); */
	ArrayList<Notice> list = new ArrayList<Notice>(map.values());
	Collections.sort(list, new NoticeNoDescending());

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/first/resources/js/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function moveWritePage(){\r\n");
      out.write("\t//글쓰기 버튼을 클릭하면, noticeWriteForm.jsp 파일로 이동함\r\n");
      out.write("\tlocation.href=\"/first/views/notice/noticeWriteForm.jsp\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\tshowDiv();\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"input[name=item]\").on(\"change\", function(){\r\n");
      out.write("\t\tshowDiv();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function showDiv(){\r\n");
      out.write("\tif($(\"input[name=item]\").eq(0).is(\":checked\")){\r\n");
      out.write("\t\t$(\"#titleDiv\").css(\"display\", \"block\");\r\n");
      out.write("\t\t$(\"#writerDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t\t$(\"#dateDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($(\"input[name=item]\").eq(1).is(\":checked\")){\r\n");
      out.write("\t\t$(\"#titleDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t\t$(\"#writerDiv\").css(\"display\", \"block\");\r\n");
      out.write("\t\t$(\"#dateDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tif($(\"input[name=item]\").eq(2).is(\":checked\")){\r\n");
      out.write("\t\t$(\"#titleDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t\t$(\"#writerDiv\").css(\"display\", \"none\");\r\n");
      out.write("\t\t$(\"#dateDiv\").css(\"display\", \"block\");\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>first</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("header nav ul { list-style: none; } \r\n");
      out.write("header nav ul li {\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\tmargin-right: 5px;\r\n");
      out.write("\tbackground: orange;\r\n");
      out.write("}\r\n");
      out.write("header nav ul li a {\r\n");
      out.write("\tdisplay: block;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("\tpadding-top: 5px;\r\n");
      out.write("\tpadding-bottom: 0;\r\n");
      out.write("\twidth: 120px;\r\n");
      out.write("\theight: 35px;\r\n");
      out.write("\tcolor: navy;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("header nav ul li a:hover {\r\n");
      out.write("\tbackground: olive;\r\n");
      out.write("\ttext-shadow: 1px 1px 2px white;\r\n");
      out.write("\tbox-shadow: 2px 2px 4px gray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("<nav>\r\n");
      out.write("<ul>\r\n");
      out.write("\t<li><a href=\"/first/index.jsp\">home</a></li>\r\n");
      out.write("\t<li><a href=\"/first/nlist\">공지사항</a></li>\r\n");
      out.write("\t<li><a href=\"/first/blist?page=1\">게시글</a></li>\r\n");
      out.write("\t<li><a href=\"\">메뉴</a></li>\r\n");
      out.write("\t<li><a href=\"\">메뉴</a></li>\r\n");
      out.write("</ul>\r\n");
      out.write("</nav>\r\n");
      out.write("</header>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<hr style=\"clear:both;\">\r\n");
      out.write("<h2 align=\"center\">공지사항 목록 보기</h2>\r\n");
      out.write("<br>\r\n");
      out.write('\r');
      out.write('\n');
 //관리자일 때만 글쓰기 제공 처리
	/* if(loginUser != null 
		&& loginUser.getUserId().equals("admin")){ */ 
	if(loginUser != null){ 
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("\t<button onclick=\"moveWritePage();\">글쓰기</button>\r\n");
      out.write("</center>\r\n");
 } 
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<center>\r\n");
      out.write("<div>\r\n");
      out.write("\t<h2>검색할 항목을 선택하시오.</h2>\r\n");
      out.write("\t<input type=\"radio\" name=\"item\" value=\"title\" checked> 제목 \r\n");
      out.write("\t&nbsp; &nbsp; &nbsp; \r\n");
      out.write("\t<input type=\"radio\" name=\"item\" value=\"writer\"> 작성자 \r\n");
      out.write("\t&nbsp; &nbsp; &nbsp; \r\n");
      out.write("\t<input type=\"radio\" name=\"item\" value=\"date\"> 날짜 \r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"titleDiv\">\r\n");
      out.write("\t<form action=\"/first/nsearch\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"search\" value=\"title\">\r\n");
      out.write("\t<label>검색할 제목을 입력하시오 : \r\n");
      out.write("\t<input type=\"text\" name=\"keyword\"></label>\r\n");
      out.write("\t<input type=\"submit\" value=\"검색\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"writerDiv\">\r\n");
      out.write("\t<form action=\"/first/nsearch\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"search\" value=\"writer\">\r\n");
      out.write("\t<label>검색할 작성자 아이디를 입력하시오 : \r\n");
      out.write("\t<input type=\"text\" name=\"keyword\"></label>\r\n");
      out.write("\t<input type=\"submit\" value=\"검색\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"dateDiv\">\r\n");
      out.write("\t<form action=\"/first/nsearch\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"search\" value=\"date\">\r\n");
      out.write("\t<label>검색할 날짜를 선택하시오 : \r\n");
      out.write("\t<input type=\"date\" name=\"begin\"> ~ \r\n");
      out.write("\t<input type=\"date\" name=\"end\"></label>\r\n");
      out.write("\t<input type=\"submit\" value=\"검색\">\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</center>\r\n");
      out.write("<br>\r\n");
      out.write("\r\n");
      out.write("<table align=\"center\" width=\"650\" cellspacing=\"0\" border=\"1\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th>번호</th>\r\n");
      out.write("\t<th>제목</th>\r\n");
      out.write("\t<th>작성자</th>\r\n");
      out.write("\t<th>날짜</th>\r\n");
      out.write("\t<th>첨부파일</th>\r\n");
      out.write("</tr>\r\n");
 
	for(Notice notice : list){

      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"center\">");
      out.print( notice.getNoticeNo() );
      out.write("</td>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t");
 if(loginUser != null){ //로그인한 상태 
      out.write("\r\n");
      out.write("\t\t<a href=\"/first/ndetail?no=");
      out.print( notice.getNoticeNo() );
      out.write('"');
      out.write('>');
      out.print( notice.getNoticeTitle() );
      out.write("</a>\r\n");
      out.write("\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t");
      out.print( notice.getNoticeTitle() );
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("\t<td align=\"center\">");
      out.print( notice.getNoticeWriter() );
      out.write("</td>\r\n");
      out.write("\t<td align=\"center\">");
      out.print( notice.getNoticeDate() );
      out.write("</td>\r\n");
      out.write("\t<td align=\"center\">\r\n");
      out.write("\t");
 if(notice.getOriginalFilePath() != null){ //첨부파일이 있다면 
      out.write("\r\n");
      out.write("\t\t◎\r\n");
      out.write("\t");
 }else{  //첨부파일이 없다면 
      out.write("\r\n");
      out.write("\t\t&nbsp;\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
  } 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<hr>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<footer align=\"center\">\r\n");
      out.write("copyright@kh.org 2019-03-04 master : 홍길동 <br>\r\n");
      out.write("tel : 02-1234-5678, 서울시 강남구 역삼동 777, fax : 02-1111-2356\r\n");
      out.write("</footer>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
