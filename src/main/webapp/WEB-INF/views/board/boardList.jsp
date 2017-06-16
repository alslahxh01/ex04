<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  리스트 제목 -->

<H1>${board} </H1>

<table>
<tr>
<td>Num</td>
<td>Title</td>
<td>Writer</td>
<td>Contents</td>
<td>Date</td>
<td>hit</td>
</tr>
<c:forEach items="${list}" var="i">
<tr>
<td>${i.num}</td>
<c:catch>
<c:forEach begin="1" end="${i.depth}">Re</c:forEach>
</c:catch>
<td><a href="${board}View?num=${i.num}">${i.title}</a></td>

<td>${i.writer}</td>
<td>${i.contents}</td>
<td>${i.reg_date}</td>
<td>${i.hit}</td>
</tr>


</c:forEach>
</table>
<br>

<a href="${board}Write">@@@@@@@@@@@@@@@@@@@@@@글작성@@@@@@@@@@@@@@@@@@@@@@</a>

</body>
</html>