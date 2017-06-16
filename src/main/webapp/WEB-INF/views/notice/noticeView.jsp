<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>View Page</h2> <br>

<a href="">Update FOrm gogo</a>
<br>


<a href="noticeDelete">Delete</a><br>

<label>글번호 : ${dto.num}</label><br>	
<label>글제목 : ${dto.title}</label><br>
<label>글내용 : ${dto.contents}</label><br>
<label>작성자 : ${dto.writer}</label><br>
<label>작성일 : ${dto.reg_date}</label><br>
<label>히트 수 : ${dto.hit}</label>

<br>
<a href="noticeUpdate?num=${dto.num}&title=${dto.title}&contents=${dto.contents}">수정</a>
<br>
<a href="noticeDelete?num=${dto.num}">삭제</a>



</body>
</html>