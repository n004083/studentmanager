<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h3 { color: #27ae60; }
        form { margin-top: 15px; }
        label { display: inline-block; width: 60px; margin-bottom: 10px; }
        input[type="text"] { padding: 5px; width: 200px; }
        input[type="submit"] { background-color: #27ae60; color: white; padding: 8px 20px; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #2ecc71; }
        .btn-back { color: #7f8c8d; text-decoration: none; margin-left: 10px; }
        .btn-back:hover { color: #95a5a6; }
    </style>
</head>
<body>
<h3>新增学生</h3>
<form action="${pageContext.request.contextPath}/InsertStudentServlet.do" method="post">
    <label>姓名：</label><input type="text" name="sname"><br>
    <label>年龄：</label><input type="text" name="sage"><br>
    <label>性别：</label><input type="text" name="ssex"><br>
    <label>班级：</label><input type="text" name="sclass"><br>
    <input type="submit" value="提交">
    <a href="${pageContext.request.contextPath}/ListStudentServlet.do" class="btn-back">返回列表</a>
</form>
</body>
</html>