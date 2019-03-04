<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	 <form action="book" method="post"> 
		<c:choose>
			<c:when test="${book !=null }">
				<input type="hidden" name="method" value="update">
				书籍编号<input type="text" name="bid" value="${book.bid }" readonly="readonly"><br/>
			</c:when>
			<c:otherwise>
				<input type="hidden" name="method" value="add">
			</c:otherwise>
		</c:choose>
		
		书籍名称：<input type="text" name="bname" value="${book.bname }"><br/>
		书籍作者：<input type="text" name="author" value="${book.author }"><br/>
		书籍价钱：<input type="text" name="price" value="${book.price }"><br/>
		
		<c:choose>
	    	<c:when test="${book !=null }">
				<input type="submit" value="修改">
	    	</c:when>
	    	<c:otherwise>
				<input type="submit" value="添加">
	    	</c:otherwise>
	    </c:choose>
		
	</form>
<%-- 		<form action="book" method="post">
	    <c:choose>
	    	<c:when test="${book !=null }">
	    	    <input type="hidden" name="method" value="update">
	    	    书籍编号:<input type="text" name="bid" value="${book.bid }" readonly="readonly"><br/>
	    	</c:when>
	    	<c:otherwise>
	   			 <input type="hidden" name="method" value="add">
	    	</c:otherwise>
	    </c:choose>
		书籍名称:<input type="text" name="bname" value="${book.bname }"><br/>
		书籍作者:<input type="text" name="author" value="${book.author }"><br/>
		书籍价格:<input type="text" name="price" value="${book.price }"><br/>
		<c:choose>
	    	<c:when test="${book !=null }">
				<input type="submit" value="修改">
	    	</c:when>
	    	<c:otherwise>
				<input type="submit" value="添加">
	    	</c:otherwise>
	    </c:choose>
	</form> --%>

</body>
</html>