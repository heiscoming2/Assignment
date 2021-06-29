<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list</h1>
	<table border="1">
		<colgroup>
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
		</colgroup>
		<tr>
			<th>NO</th>
			<th>WRITER</th>
			<th>TITLE</th>
			<th>DATE</th>
		</tr>
		
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="4" align="center">--------------작성된 글이 없습니다-----------------</td>
				</tr>
			</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.bno}</td>
					<td>${dto.bname}</td>
					<td><a href="detail.do?bno=${dto.bno}">${ dto.btitle}</a></td>
					<td>${dto.bdate}</td>
				</tr>
			</c:forEach>
		</c:otherwise>		
		</c:choose> 
		
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글작성" onclick="location.href='insertform.do'">
			</td>
		</tr>
	</table>


</body>
</html>	