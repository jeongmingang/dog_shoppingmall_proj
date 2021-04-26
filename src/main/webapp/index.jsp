<%@page import="dog_shoppingmall_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연결 테스트</title>
</head>
<body>
db테스트 테스트 <br>
<%=JndiDS.getConnection()%>
</body>
</html>