package model;

import dbutil.Dbconn;
import entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectStudent {
    public Student getById(int sid) {
        Student s=null;
        Connection conn=Dbconn.getConn();
        String sql="select * from student where sid=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, sid);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                s=new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setSage(rs.getInt("sage"));
                s.setSsex(rs.getString("ssex"));
                s.setSclass(rs.getString("sclass"));
            }
            Dbconn.close(conn,pstmt,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}