<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <h2>欢迎使用学生系统</h2>
        
        <form action="LoginSelvlet" method="post">
         账号：<input type="text" name="username" /><br>
          密码：<input type="password" name="password" /><br>
          <input type="submit" value="登陆">
        
        </form>
        <a href="register.jsp"><h2>注册</h2></a>
</body>
</html>