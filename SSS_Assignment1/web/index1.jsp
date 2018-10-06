<%--
  Created by IntelliJ IDEA.
  User: viraj
  Date: 8/6/18
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Double submit cookie pattern</title>
<link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<div class="form">
    <form method="POST" class="DS" action="Validate1">
        <input type="text" name="Enter email" placeholder="email" required/><br><br>
        <input type="hidden" id="token" name="token" value="${CSRFToken}">
        <input type="submit" name="submit" value="Submit">
    </form>
</div>
</body>
</html>


