package control;

import model.UpdateStudent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int sid=Integer.parseInt(request.getParameter("sid"));
        String sname=request.getParameter("sname");
        int sage=Integer.parseInt(request.getParameter("sage"));
        String ssex=request.getParameter("ssex");
        String sclass=request.getParameter("sclass");

        UpdateStudent model=new UpdateStudent();
        model.update(sid, sname, sage, ssex, sclass);

        response.sendRedirect("ListStudentServlet.do");
    }
}