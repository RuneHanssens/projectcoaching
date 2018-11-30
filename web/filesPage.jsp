<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Files</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jspf"%>
<div class="container">
    <a href="${pageContext.request.contextPath}/Controller?action=downloadPdf" class="btn btn-outline-danger">Download pdf</a>
    <a href="${pageContext.request.contextPath}/Controller?action=downloadExcel&type=1" class="btn btn-outline-danger">Download excel xlsx</a>
    <a href="${pageContext.request.contextPath}/Controller?action=downloadExcel&type=2" class="btn btn-outline-danger">Download excel xls</a>
</div>
<%@include file="import.jspf"%>
</body>
</html>
