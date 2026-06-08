package control;

import model.ImportStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
public class ImportStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("jsp/studentimport.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Part filePart = request.getPart("excelFile");
        String fileName = filePart.getSubmittedFileName();
        
        if (fileName == null || (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls"))) {
            request.setAttribute("message", "请选择有效的Excel文件(.xlsx或.xls)");
            request.getRequestDispatcher("jsp/studentimport.jsp").forward(request, response);
            return;
        }
        
        InputStream inputStream = filePart.getInputStream();
        ImportStudent model = new ImportStudent();
        
        if (model.importFromExcel(inputStream, fileName)) {
            response.sendRedirect("ListStudentServlet.do");
        } else {
            request.setAttribute("message", "导入失败，请检查文件格式");
            request.getRequestDispatcher("jsp/studentimport.jsp").forward(request, response);
        }
    }
}