package model;

import dbutil.Dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteStudent {
    public boolean del(int sid) {
        Connection conn=Dbconn.getConn();
        String sql="delete from student where sid=?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, sid);
            int i=pstmt.executeUpdate();
            Dbconn.close(conn,pstmt,null);
            return i>0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}