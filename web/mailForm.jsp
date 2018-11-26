<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jspf"%>
<form action = "Controller" method = "GET">
    email <input type = "text" name = "email">
    <input type="hidden" value="sendMail" name="action">
    <input type = "submit" value = "Send mail" />
</form>
<%@include file="import.jspf"%>
</body>
</html>
