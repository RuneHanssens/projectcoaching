<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jspf"%>
<div class="container">
    <form action = "Controller" method = "GET">
        <div class="form-group">
            <label for="email">email</label>
            <input type = "text" name = "email" id="email" class="form-control" placeholder="Enter your email here...">
        </div>
        <input type="hidden" value="sendMail" name="action">
        <input type = "submit" value = "Send mail" class="btn btn-default"/>
    </form>
</div>
<%@include file="import.jspf"%>
</body>
</html>
