<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>
<style>
.pageDiv{display: flex; justify-content: center;}
	.pageDiv ul{
		list-style: none;
		display: flex;
		flex-direction: row;
	}
	.pageDiv ul li{padding-left:0.3em}
</style>
<div class="listDiv">
${list}
</div>

<div class="pageDiv">
	<ul>
	<c:if test="${pg.prev }">
		<li><a href="${pg.start - 1 }">  이전</a></li>
	</c:if>
		<c:forEach begin="${pg.start}" end="${pg.end}" var="num">
		<li><a href="${num}">${num}</a></li>
		</c:forEach>
		<c:if test="${pg.next }">
		<li><a href="${pg.end + 1 }"> 다음</a></li>
	</c:if>
	</ul>
</div>
<form id="f1" method="get">
	<input type="hidden" name="page" value="${pg.dto.page}">
	<input type="hidden" name="amount" value="${pg.dto.amount}">
	
	<select name="type">
		<option value="">--</option>
		<option value="T" ${pg.dto.type == "T"?"selected":""}>제목</option>
		<option value="C" ${pg.dto.type == "C"?"selected":""}>내용</option>
		<option value="W" ${pg.dto.type == "W"?"selected":""}>작성자</option>
		<option value="TC" ${pg.dto.type == "TC"?"selected":""}>제목+내용</option>
		<option value="CW" ${pg.dto.type == "CW"?"selected":""}>내용+작성자</option>
		<option value="TCW" ${pg.dto.type == "TCW"?"selected":""}>제목+내용+작성자</option>
	</select>
<%-- 	<input type="text" name="type" value="${pg.dto.type}"> --%>
	<input type="text" name="keyword" value="${pg.dto.keyword}">
</form>

<button id="searchBtn">Search</button>

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
  
  <script>
  $(document).ready(function() {
	  
	  var f1 = $("#f1");
	  
	  $("#searchBtn").on("click", function(e){
		  $("input[name='page']").val(1);
		  f1.submit();
	  })
	  
	  
	  $(".pageDiv ul").on("click", "a", function(e){
		 
		  e.preventDefault();
		  console.log("click");
		  var pageNum = $(this).attr("href");
		  console.log("pageNum: " + pageNum);
		  
		  $("input[name='page']").val(pageNum);
		  
		  f1.submit();
	  });
	  
  });
  </script>

</body>
</html>