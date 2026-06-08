package model;

import dbutil.Dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertStudent {
    public boolean add(String sname, int sage, String ssex, String sclass) {
        Connection conn=Dbconn.getConn();
        String sql="insert into student(sname,sage,ssex,sclass) values(?,?,?,?)";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, sname);
            pstmt.setInt(2, sage);
            pstmt.setString(3, ssex);
            pstmt.setString(4, sclass);
            int i=pstmt.executeUpdate();
            Dbconn.close(conn,pstmt,null);
            return i>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}