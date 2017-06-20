<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
span{
cursor: pointer;
}

</style>
<script type="text/javascript">
$(function(){

		
		$(".ing").click(function(){
			//방법 1.
// 			var cur = $(this).attr("id");
// 			location.href="${board}List?curPage="+cur+"&search=${listInfo.search}&find=${listInfo.find}";
			//방법 2.
			document.frm.curPage.value = $(this).attr("id");
			document.frm.search.value = '${listInfo.search}';
			document.frm.find.value = '${listInfo.find}';
			document.frm.submit();
			
			
			
			
		});

	
});
</script>
</head>
<body>
<!--  리스트 제목 -->

<H1>${board} </H1>


<div>
<form action="${board}List" name="frm"> <!-- 검색해도 List형식으로 보여줘야 한다. -->
<input type="hidden" name="curPage">
<select name="search">
<option value="title">Title</option>
<option value="writer">Writer</option>
<option value="contents">Contents</option>
</select>
<input type="text" name="find">
<input type="submit" value="Search">
</form>
</div>
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
<c:if test="${listInfo.curBlock > 1 }">
<span class="ing" id="${listInfo.startNum-1}">[이전]</span>
</c:if>
<c:forEach begin="${listInfo.startNum }" end="${listInfo.lastNum}" var="i">
<span class="ing" id="${i}">${i}</span>
</c:forEach>
<c:if test="${listInfo.curBlock < listInfo.totalBlock}">
<span class="ing" id="${listInfo.lastNum+1}">[다음]</span>
</c:if>
<br>
<a href="${board}Write">@@@@@@@@@@@@@@@@@@@@@@글작성@@@@@@@@@@@@@@@@@@@@@@</a>


</body>
</html>