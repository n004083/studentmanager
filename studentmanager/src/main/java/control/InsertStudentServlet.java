package control;

import model.InsertStudent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/jsp/studentinsert.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sname=request.getParameter("sname");
        int sage=Integer.parseInt(request.getParameter("sage"));
        String ssex=request.getParameter("ssex");
        String sclass=request.getParameter("sclass");

        InsertStudent model=new InsertStudent();
        model.add(sname, sage, ssex, sclass);

        response.sendRedirect("ListStudentServlet.do");
    }
}