<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Images</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<%@include file="nav.jspf" %>
<div class="container">
    <div class="row">
        <c:forEach items="${keys}" var="key">
            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-6">
                <a href="Controller?action=downloadImage&key=${key}">
                    <img class="my_image" src="Controller?action=downloadImage&key=${key}" alt="" style="width:365px; margin-top:30px">
                </a>
            </div>
        </c:forEach>
    </div>
</div>
<form action="Controller?action=uploadImage" method="post" enctype="multipart/form-data">
    <input type="hidden" value="uploadImage" name="action"/>
    <input type="file" name="file"/>
    <input type="submit" value="upload"/>
</form>
<%@include file="import.jspf" %>
</body>
</html>
