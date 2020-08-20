<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
<link href="/temp.css" rel="stylesheet" /> 
</head>
<body>
<div class="container">
		<h1>Grades</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th><th>Type</th><th>Score</th><th>Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="grade" items="${grade}">
				<tr>
					<td><a href="/homepage/detail?id=${grade.id}">${grade.name}</a></td>
					<td>${grade.score}</td>
					<td>${grade.total}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/homepage/add-form" class="btn btn-secondary">Add Grade</a>
	</div>
</body>
</html>