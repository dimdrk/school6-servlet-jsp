<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Εμφάνιση Καθηγητή</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/teacher-view.css">
</head>
<body>
<%@ include file="header.jsp"%>
<div class="main-content">

    <div class="form m-bottom">
        <form method="POST" action="${pageContext.request.contextPath}/teachers/view">
            <div class="row m-bottom">
                <label for="tid">Κωδικός</label>
                <input id="tid" type="text" name="id" value="${requestScope.readOnlyDTO.id}" readonly>
            </div>

            <div class="row m-bottom">
                <label for="firstname">Όνομα</label>
                <input id="firstname" type="text" name="firstname" value="${requestScope.readOnlyDTO.firstname}" readonly>
            </div>

            <div class="row m-bottom">
                <label for="lastname">Επώνυμο</label>
                <input id="lastname" type="text" name="lastname" value="${requestScope.readOnlyDTO.lastname}" readonly>
            </div>
        </form>
    </div>

    <div class="m-bottom">
        <a href="${pageContext.request.contextPath}/teachers">Επιστροφή</a>
    </div>

    <div>
        ${requestScope.errorMessage}
    </div>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>
