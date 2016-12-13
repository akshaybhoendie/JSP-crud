<%--
  Created by IntelliJ IDEA.
  User: abhoendie
  Date: 12/7/2016
  Time: 2:50 PM
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
    <title>Toevoegen Persoon</title>
</head>
<body>
<br/>
<br/>
<br/>
<div class="container">
    <h2>Persoon Toevoegen</h2>
    <form method="post" action="PersoonController" name="frmAddPersoon" class="form-horizontal">
        <div class="form-group">
            <label class="control-label col-sm-2">PersoonId:</label>
            <div class="col-sm-10">
                <input type="text" readonly="readonly" class="form-control" name="persoonid" placeholder="Persoonid"
                       value="<c:out value="${persoon.persoonId}"/>" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Naam :</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required="true" name="naam" placeholder="Naam"
                       value="<c:out value="${persoon.naam}" />" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Voornaam:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required="true" name="voornaam" placeholder="Voornaam"
                       value="<c:out value="${persoon.voornaam}" />" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Adress:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" required="true" name="adress" placeholder="Adress"
                       value="<c:out value="${persoon.adress}" />" />
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2">Geboortedatum:</label>
            <div class="col-sm-10">
                <input type="date" class="form-control" required="true" name="geboortedatum" placeholder="Geboortedatum"
                       value="<c:out value="${persoon.geboorteDatum}" />" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" value="Submit" class="btn btn-default">Opslaan</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
