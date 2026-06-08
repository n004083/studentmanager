package control;

import model.SelectStudent;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sid=Integer.parseInt(request.getParameter("sid"));
        SelectStudent model=new SelectStudent();
        Student s=model.getById(sid);
        request.setAttribute("stu", s);
        request.getRequestDispatcher("jsp/studentshow.jsp").forward(request, response);
    }
}