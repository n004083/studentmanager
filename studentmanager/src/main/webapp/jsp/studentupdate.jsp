<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h3 { color: #f39c12; }
        form { margin-top: 15px; }
        label { display: inline-block; width: 60px; margin-bottom: 10px; }
        input[type="text"] { padding: 5px; width: 200px; }
        input[type="submit"] { background-color: #f39c12; color: white; padding: 8px 20px; border: none; border-radius: 4px; cursor: pointer; }
        input[type="submit"]:hover { background-color: #f1c40f; }
        .btn-back { color: #7f8c8d; text-decoration: none; margin-left: 10px; }
        .btn-back:hover { color: #95a5a6; }
    </style>
</head>
<body>
<h3>修改学生</h3>
<% Student s=(Student)request.getAttribute("stu"); %>
<form action="${pageContext.request.contextPath}/DoStudentServlet.do" method="post">
    <input type="hidden" name="sid" value="<%=s.getSid()%>">
    <label>姓名：</label><input type="text" name="sname" value="<%=s.getSname()%>"><br>
    <label>年龄：</label><input type="text" name="sage" value="<%=s.getSage()%>"><br>
    <label>性别：</label><input type="text" name="ssex" value="<%=s.getSsex()%>"><br>
    <label>班级：</label><input type="text" name="sclass" value="<%=s.getSclass()%>"><br>
    <input type="submit" value="保存">
    <a href="${pageContext.request.contextPath}/ListStudentServlet.do" class="btn-back">返回列表</a>
</form>
</body>
</html>