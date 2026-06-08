package model;

import dbutil.Dbconn;
import entity.Student;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ImportStudent {
    public List<Student> readExcel(InputStream inputStream, String fileName) throws Exception {
        List<Student> list = new ArrayList<>();
        Workbook workbook = null;
        
        if (fileName.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileName.endsWith(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new Exception("不支持的文件格式");
        }
        
        Sheet sheet = workbook.getSheetAt(0);
        
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            
            Student student = new Student();
            student.setSname(getCellValue(row.getCell(0)));
            student.setSage(Integer.parseInt(getCellValue(row.getCell(1))));
            student.setSsex(getCellValue(row.getCell(2)));
            student.setSclass(getCellValue(row.getCell(3)));
            list.add(student);
        }
        
        workbook.close();
        return list;
    }
    
    private String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
    
    public boolean importFromExcel(InputStream inputStream, String fileName) {
        try {
            List<Student> list = readExcel(inputStream, fileName);
            Connection conn = Dbconn.getConn();
            String sql = "INSERT INTO student(sname, sage, ssex, sclass) VALUES(?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            
            for (Student student : list) {
                pstmt.setString(1, student.getSname());
                pstmt.setInt(2, student.getSage());
                pstmt.setString(3, student.getSsex());
                pstmt.setString(4, student.getSclass());
                pstmt.addBatch();
            }
            
            pstmt.executeBatch();
            Dbconn.close(conn, pstmt, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}