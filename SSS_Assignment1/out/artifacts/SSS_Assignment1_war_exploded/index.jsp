<%--
  Created by IntelliJ IDEA.
  User: viraj
  Date: 8/5/18
  Time: 11:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Synchronizer Token Pattern</title>
    <link rel="stylesheet" type="text/css" href="css.css">
</head>
<body>
<div class="form">
<form method="POST" class="STP" action="Validate">
    <input type="text" name="Enter email" placeholder="email" required/><br><br>
    <input type="hidden" id="token" name="token" value="${sessionScope.CSRFToken}">
    <input type="submit" name="submit" value="Submit">
</form>
</div>
</body>
</html>
