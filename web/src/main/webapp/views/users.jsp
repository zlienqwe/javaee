<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>user information</title>
</head>
<body>
<a type="button" href="/web/host/logout">退出登录</a>

<h1>用户信息列表</h1>

<form id="iform"  method="post" action="/web/users">
  Name:<br/>
  <input type="text"  name="name" /><br/>
  Age:<br/>
  <input type="text" name="age" /><br/>
  Sex:<br/>
  <input type="radio" name="sex" value="男">男
  <input type="radio" name="sex" value="女">女
  <br/>
  Mail:<br/>
  <input type="text" name="mail" /><br/>
  <input type="submit" value="增加"/>
</form>
<table border="1">
  <thead>
    <th>姓名</th>
    <th>性别</th>
    <th>邮箱</th>
    <th>年龄</th>
    <th>删除</th>
    <th>修改</th>
  </thead>

  <tbody>
<c:forEach items="${users}" var="user">
  <tr>
    <td>${user.userName}</td>
    <td>${user.userSex}</td>
    <td>${user.userMail}</td>
    <td>${user.userAge}</td>
    <td><a href="/web/users/delete/${user.userId}">删除</a></td>
    <td><a href="/web/users/update/${user.userId}">修改</a></td>
  </tr>
</c:forEach>
  </tbody>
</table>
</body>
</html>
