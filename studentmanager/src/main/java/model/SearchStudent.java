package model;

import dbutil.Dbconn;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SearchStudent {
    public List<Student> getAll() {
        List<Student> list=new ArrayList<>();
        Connection conn=Dbconn.getConn();
        String sql="select * from student";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()) {
                Student s=new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getInt("sage"));
                s.setSsex(rs.getString("ssex"));
                s.setSclass(rs.getString("sclass"));
                list.add(s);
            }
            Dbconn.close(conn,pstmt,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}