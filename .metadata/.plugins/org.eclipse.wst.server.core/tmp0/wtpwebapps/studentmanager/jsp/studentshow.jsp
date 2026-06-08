<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entity.Student" %>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h3 { color: #9b59b6; }
        .info { margin-top: 15px; line-height: 1.8; }
        .btn-delete { background-color: #e74c3c; color: white; padding: 8px 16px; text-decoration: none; border-radius: 4px; }
        .btn-delete:hover { background-color: #c0392b; }
        .btn-back { color: #7f8c8d; text-decoration: none; margin-left: 10px; }
        .btn-back:hover { color: #95a5a6; }
    </style>
</head>
<body>
<h3>学生详情</h3>
<div class="info">
<% Student s=(Student)request.getAttribute("stu"); %>
学号：<%=s.getSid()%><br>
姓名：<%=s.getSname()%><br>
年龄：<%=s.getSage()%><br>
性别：<%=s.getSsex()%><br>
班级：<%=s.getSclass()%><br>
</div>
<a href="${pageContext.request.contextPath}/DeleteStudentServlet.do?sid=<%=s.getSid()%>" class="btn-delete">删除</a>
<a href="${pageContext.request.contextPath}/ListStudentServlet.do" class="btn-back">返回列表</a>
</body>
</html>