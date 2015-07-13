<%--
  Created by IntelliJ IDEA.
  User: twer
  Date: 15/7/8
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title></title>
</head>
<body>


<form  method="post" action="/web/update">
  <input type="hidden" name="id" value="${user.userId}"/>
  Name:<br/>
  <input type="text"  name="name" value="${user.userName}"/><br/>
  Age:<br/>
  <input type="text" name="age" value="${user.userAge}"/><br/>
  Sex:<br/>
  <c:if test="${user.userSex=='男'}">
    <input type="radio" name="sex" value="男" checked>男
    <input type="radio" name="sex" value="女"} >女
  </c:if>
  <c:if test="${user.userSex=='女'}">
    <input type="radio" name="sex" value="男">男
    <input type="radio" name="sex" value="女" checked >女
  </c:if>
  <br/>
  Mail:<br/>
  <input type="text" name="mail" value="${user.userMail}"/><br/>
  <input type="submit" value="修改"/>
</form>

</body>
</html>
