<%--
  Created by IntelliJ IDEA.
  User: wujian
  Date: 2018-05-26
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/static/lib/jquery/jquery-3.3.1.min.js"></script>
</head>
<body>
<form action="/system/checkLogin.do" method="post">
    ${param.msg}<br>
    用户名 <input type="text" name="userName"><br>
    密码 <input type="text" name="passWord"> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>