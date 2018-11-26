<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Files</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jspf"%>
<a href="/Controller?action=downloadPdf">Download pdf</a>
<a href="/Controller?action=downloadExcel">Download excel</a>
<%@include file="import.jspf"%>
</body>
</html>
