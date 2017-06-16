<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Write FOrm Page</h2>

<form action="notice${path}" method="post">

<input type="hidden" value="${dto.num}" name="num">
<input type="text" value="${dto.title}" name="title">
<input type="text" value="${dto.contents}" name="contents">
<input type="text" value="${dto.writer}" name="writer">
<input type="date" value="${dto.reg_date }" name="reg_date">
<button id="btn">보내기</button>




</form>
</body>
</html>