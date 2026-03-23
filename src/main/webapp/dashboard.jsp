<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Dashboard - SafeVault</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background: linear-gradient(135deg,#1d2671,#c33764);
height:100vh;
display:flex;
justify-content:center;
align-items:center;
font-family:Arial;
}

.dashboard-card{
background:white;
padding:40px;
border-radius:15px;
width:420px;
box-shadow:0 8px 25px rgba(0,0,0,0.3);
text-align:center;
}

.btn-custom{
width:100%;
margin-top:15px;
padding:12px;
font-size:16px;
}

</style>

</head>

<body>

<div class="dashboard-card">

<h2 class="mb-4">🔐 SafeVault Dashboard</h2>

<%
String msg=(String)session.getAttribute("msg");

if(msg!=null){
%>

<div class="alert alert-success">
<%=msg%>
</div>

<%
session.removeAttribute("msg");
}
%>

<a href="upload.jsp" class="btn btn-primary btn-custom">
📤 Upload Document
</a>

<a href="ViewDocumentsServlet" class="btn btn-success btn-custom">
📂 View Documents
</a>

<a href="logout.jsp" class="btn btn-danger btn-custom">
🚪 Logout
</a>

</div>

</body>
</html>