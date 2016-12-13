<%--
  Created by IntelliJ IDEA.
  User: abhoendie
  Date: 12/7/2016
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Toon Personen</title>
</head>
<body>

<br />
<br />

<div class="container">
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead>
            <tr>
                <th>PersoonId</th>
                <th>Naam</th>
                <th>Voornaam</th>
                <th>Adress</th>
                <th>GeboorteDatum</th>
                <th colspan=2>Action</th>
            </tr>
            </thead>
            <tbody>
            <%--@elvariable id="persoon" type="java.util.List"--%>
            <c:forEach items="${personen}" var="persoon">
                <tr>
                    <td><c:out value="${persoon.persoonId}"/></td>
                    <td><c:out value="${persoon.naam}"/></td>
                    <td><c:out value="${persoon.voornaam}"/></td>
                    <td><c:out value="${persoon.adress}"/></td>
                    <td><c:out value="${persoon.geboorteDatum}"/></td>
                    <td><a href="PersoonController?action=edit&persoonid=<c:out value="${persoon.persoonId}"/>">Update</a></td>
                    <td><a href="PersoonController?action=delete&persoonid=<c:out value="${persoon.persoonId}"/>">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p><a href="PersoonController?action=insert">Add User</a></p>
    </div>
</div>


</body>
</html>