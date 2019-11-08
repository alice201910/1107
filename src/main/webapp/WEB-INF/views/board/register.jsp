<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Register</h1>

<form:form method="post" modelAttribute="vo">
	<p>
		<input type="text" name="title">
			<form:errors path="title"></form:errors>            
	</p>
	<p>
		<input type="text" name="content">
			<form:errors path="content"></form:errors> 
	</p>
	<p>
		<input type="text" name="writer">
	</p>
	<p>
		<button>Register</button>
	</p>
</form:form>

</body>
</html>