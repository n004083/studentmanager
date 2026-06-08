package control;

import model.DeleteStudent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sid=Integer.parseInt(request.getParameter("sid"));
        DeleteStudent model=new DeleteStudent();
        model.del(sid);
        response.sendRedirect("ListStudentServlet.do");
    }
}