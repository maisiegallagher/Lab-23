<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Graded Added Confirmation</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">

		<h3 class="display-4"> Grade Added</h3>

<p> The grade was added to the database. </p>

<h2>Details</h2>
		<p>
			Name:
			<c:out value="${ name }" />
		</p>

		<p>
		Type: 
		<c:out value="${ type }" />
		</p>

		<p>
		Score:
		<c:out value="${ score }" />
		</p>
		<p>
		Total:
		<c:out value="${ total }" />
		</p>

	</div>
	<ul>
		<li><a href="/">Return to grade list</a></li>
	</ul>

</body>
</html>