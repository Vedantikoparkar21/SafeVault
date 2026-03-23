<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>

<title>My Documents</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background: linear-gradient(to right,#8360c3,#2ebf91);
min-height:100vh;
padding-top:60px;
}

.container-box{
background:white;
padding:30px;
border-radius:15px;
box-shadow:0 6px 20px rgba(0,0,0,0.3);
}

</style>

</head>

<body>

<div class="container">

<div class="container-box">

<h3 class="text-center mb-4">My Uploaded Documents</h3>

<table class="table table-striped table-bordered">

<tr class="table-dark">
<th>Document Name</th>
<th>Download</th>
<th>Delete</th>
</tr>

<%

List<String> docs=(List<String>)request.getAttribute("documents");

if(docs!=null){

for(String file:docs){
%>

<tr>

<td><%=file%></td>

<td>
<a href="DownloadServlet?file=<%=file%>" class="btn btn-success btn-sm">
Download
</a>
</td>

<td>
<a href="DeleteServlet?file=<%=file%>" class="btn btn-danger btn-sm">
Delete
</a>
</td>

</tr>

<%
}
}
%>

</table>

<div class="text-center mt-3">

<a href="dashboard.jsp" class="btn btn-primary">
Back to Dashboard
</a>

</div>

</div>

</div>

</body>
</html>