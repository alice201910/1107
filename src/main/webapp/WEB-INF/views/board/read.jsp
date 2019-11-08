<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Read Page</h1>
	<h1>${dto.bno}</h1>

	${board}

	<form id="f1" action="/board/list" method="get">
		<input type="hidden" name="page" value="${dto.page}"> 
			<input type="hidden" name="amount" value="${dto.amount}"> 
			<input type="hidden" name="type" value="${dto.type}"> 
			<input type="hidden" name="keyword" value="${dto.keyword}">
		<button>GO TO LIST</button>
	</form>

</body>
</html>