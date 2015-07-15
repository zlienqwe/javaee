<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>user login</title>
</head>
<body>
<h1>用户登陆</h1>

<form id="login"  method="post" action="">
  用户名:<br/>
  <input type="text"  name="name" /><br/>
  密码:<br/>
  <input type="password" name="password" /><br/>
  <input type="submit" value="登陆"/>
</form>


</body>
</html>
