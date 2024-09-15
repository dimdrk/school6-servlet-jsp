<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Αποτυχία Εισόδου</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/failure.css">
</head>
<body>

	<div class="failure m-bottom">
		<h1>Αποτυχία Εισόδου</h1>
		<p>Αδυναμία πρόσβασης στην συγκεκριμένη σελίδα.</p>
	</div>	
	 	
	<div>
		<a href="${pageContext.request.contextPath}/login">Επιστροφή</a>
	</div> 	
</body>
</html>
