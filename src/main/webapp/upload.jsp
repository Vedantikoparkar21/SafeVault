<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<title>Upload Document</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>

body{
background:#f5f5f5;
height:100vh;
display:flex;
justify-content:center;
align-items:center;
}

.card{
width:420px;
padding:35px;
border-radius:15px;
box-shadow:0 6px 20px rgba(0,0,0,0.3);
}

</style>

</head>

<body>

<div class="card">

<h3 class="text-center mb-4">📤 Upload Document</h3>

<form action="UploadServlet" method="post" enctype="multipart/form-data">

<div class="mb-3">

<label>Select Document</label>

<input type="file" name="document" class="form-control" required>

</div>

<button class="btn btn-primary w-100">
Upload
</button>

</form>

<br>

<a href="dashboard.jsp" class="btn btn-primary">
Back to Dashboard
</a>

</div>

</body>
</html>