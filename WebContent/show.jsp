<%@page import="entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎你, ${username}<br/>
	<a href="addAndUpdate.jsp">添加</a>
	<a href="book?method=queryAll">查询所有</a>
		<!-- <a href="main.jsp"></a> -->
	<%-- ${books} --%>
	<table width="500px" cellspacing="0" cellpadding="5" border="1">
		<%-- <%
		
		List<Book> books = (List<Book>)request.getAttribute("books");
			
		%> --%>
		<tr>
			<td>编号</td>
			<td>名称</td>
			<td>作者</td>
			<td>价钱</td>
			<td>操作</td>
		</tr>
		<%-- <% 
			for(int i = 0; i<books.size();i++){
				Book book = books.get(i);
				request.setAttribute("book", book);
		%>	
			 --%>
			 <c:forEach items="${books }" var="book">
			<tr>
				<td>${book.bid }</td>
				<td>${book.bname }</td>
				<td>${book.author }</td>
				<td>${book.price }</td>
				<td><a href="book?method=queryOne&bid=${book.bid }">修改</a>&nbsp;<a href="book?method=del&bid=${book.bid }">删除</a></td>
			</tr>
			
				<%-- ${books } --%>
				
			</c:forEach>
			
		<%-- 	<% 
		}
		%> --%>
	</table>
</body>
</html>