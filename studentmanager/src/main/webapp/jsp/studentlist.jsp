<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,entity.Student" %>
<html>
<head>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        h3 { color: #2c3e50; }
        .btn-add { background-color: #3498db; color: white; padding: 8px 16px; text-decoration: none; border-radius: 4px; margin-right: 10px; }
        .btn-add:hover { background-color: #2980b9; }
        .btn-import { background-color: #1abc9c; color: white; padding: 8px 16px; text-decoration: none; border-radius: 4px; }
        .btn-import:hover { background-color: #16a085; }
        table { border-collapse: collapse; width: 80%; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        .btn-view { color: #e74c3c; text-decoration: none; margin-right: 10px; }
        .btn-view:hover { text-decoration: underline; }
        .btn-edit { color: #27ae60; text-decoration: none; }
        .btn-edit:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h3>学生列表</h3>
<a href="${pageContext.request.contextPath}/jsp/studentinsert.jsp" class="btn-add">新增学生</a>
<a href="${pageContext.request.contextPath}/ImportStudentServlet.do" class="btn-import">批量导入</a>
<table border="1" width="80%">
    <tr>
        <th>学号</th><th>姓名</th><th>年龄</th><th>性别</th><th>班级</th><th>操作</th>
    </tr>
    <%
        List<Student> list=(List<Student>)request.getAttribute("stuList");
        if(list != null && !list.isEmpty()){
            for(Student s:list){
    %>
    <tr>
        <td><%=s.getSid()%></td>
        <td><%=s.getSname()%></td>
        <td><%=s.getSage()%></td>
        <td><%=s.getSsex()%></td>
        <td><%=s.getSclass()%></td>
        <td>
            <a href="${pageContext.request.contextPath}/ShowStudentServlet.do?sid=<%=s.getSid()%>" class="btn-view">查看/删除</a>
            <a href="${pageContext.request.contextPath}/UpStudentServlet.do?sid=<%=s.getSid()%>" class="btn-edit">修改</a>
        </td>
    </tr>
    <%}} else { %>
    <tr><td colspan="6" style="text-align:center;">暂无学生数据</td></tr>
    <%}%>
</table>
</body>
</html>