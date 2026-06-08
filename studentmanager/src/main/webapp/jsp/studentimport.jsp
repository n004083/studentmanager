<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h3 { color: #1abc9c; }
        form { margin-top: 15px; }
        input[type="file"] { margin-bottom: 10px; }
        input[type="submit"] { background-color: #1abc9c; color: white; padding: 8px 20px; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #16a085; }
        .btn-back { color: #7f8c8d; text-decoration: none; margin-left: 10px; }
        .btn-back:hover { color: #95a5a6; }
        .message { color: #e74c3c; margin-top: 10px; }
        .note { color: #7f8c8d; font-size: 14px; margin-top: 10px; }
    </style>
</head>
<body>
<h3>批量导入学生</h3>
<form action="${pageContext.request.contextPath}/ImportStudentServlet.do" method="post" enctype="multipart/form-data">
    <input type="file" name="excelFile" accept=".xlsx,.xls"><br>
    <input type="submit" value="导入">
    <a href="${pageContext.request.contextPath}/ListStudentServlet.do" class="btn-back">返回列表</a>
</form>
<div class="note">
    <p>Excel文件格式要求：</p>
    <ul>
        <li>第一行为表头：姓名、年龄、性别、班级</li>
        <li>从第二行开始为数据</li>
        <li>支持.xlsx和.xls格式</li>
    </ul>
</div>
<% if (request.getAttribute("message") != null) { %>
<div class="message"><%= request.getAttribute("message") %></div>
<% } %>
</body>
</html>