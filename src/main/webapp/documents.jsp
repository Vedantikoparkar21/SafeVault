<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>

<title>My Documents</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">

<div class="container mt-5">

<div class="card shadow p-4">

<h3 class="text-center mb-4">My Uploaded Documents</h3>
<table class="table table-bordered">

<tr>
<th>Document Name</th>
<th>Download</th>
</tr>

<%
ArrayList<String[]> docs = (ArrayList<String[]>)request.getAttribute("documents");

if(docs != null){
for(String[] d : docs){
%>

<tr>
<td><%= d[1] %></td>

<td>
<a href="DownloadServlet?id=<%= d[0] %>" class="btn btn-success">
Download
</a>
</td>

</tr>

<%
}
}
%>

</table>

</div>

</div>

</body>
</html>