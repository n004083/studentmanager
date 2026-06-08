package model;

import dbutil.Dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStudent {
    public boolean update(int sid,String sname,int sage,String ssex,String sclass) {
        Connection conn=Dbconn.getConn();
        String sql="update student set sname=?,sage=?,ssex=?,sclass=? where sid=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, sname);
            pstmt.setInt(2, sage);
            pstmt.setString(3, ssex);
            pstmt.setString(4, sclass);
            pstmt.setInt(5, sid);
            int i=pstmt.executeUpdate();
            Dbconn.close(conn,pstmt,null);
            return i>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}