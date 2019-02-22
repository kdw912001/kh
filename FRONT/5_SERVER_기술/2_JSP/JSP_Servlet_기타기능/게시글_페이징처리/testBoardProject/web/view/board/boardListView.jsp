<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.model.vo.Board, java.util.*, java.sql.Date" %>
<%
	Map<Integer, Board> map = (Map<Integer, Board>)request.getAttribute("map");
	Set<Integer> keyList = map.keySet();
	Iterator<Integer> keyIter = keyList.iterator();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
</head>
<body>
<h1 align="center">게시글 목록 보기</h1>
<table align="center" border="1" cellspacing="0" width="700">
<tr><th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th></tr>
<%
	while(keyIter.hasNext()){
		Board b = map.get(keyIter.next());
%>
<tr><td><%= b.getBoardNum() %></td>
	<td><%= b.getBoardTitle() %></td>
	<td><%= b.getBoardWriter() %></td>
	<td><%= b.getBoardDate() %></td>
	<td><%= b.getBoardReadCount() %></td>
</tr>
<%		
	}
%>
</table>
<br>
<div align="center">
<a>처음</a>
<a>이전</a>
<a>1</a>
<a>2</a>
<a>3</a>
<a>다음</a>
<a>마지막</a>
</div>
</body>
</html>