<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.User"%>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン結果</title>
</head>
<body>
<% if(loginUser != null) { %>
	<p>ログイン成功</p>
<% }else{ %>
	<p>ログイン失敗</p>
<% } %>
</body>
</html>