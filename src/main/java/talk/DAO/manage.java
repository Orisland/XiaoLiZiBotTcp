package talk.DAO;

import talk.talk;
import db.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class manage {       //增删查改

    public static List<talk> all() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<talk> talks = new ArrayList<talk>();

        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM talk";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                talk talk1 = new talk();
                talk1.setId(rs.getInt(1));
                talk1.setKey(rs.getString(2));
                talk1.setValue(rs.getString(3));
                talk1.setPower(rs.getString(4));
                talk1.setFrom(rs.getString(5));
                talks.add(talk1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }
        return talks;
    }

    public static void add(talk talk) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into talk values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,talk.getId());
            ps.setString(2,talk.getKey());
            ps.setString(3,talk.getValue());
            ps.setString(4,talk.getPower());

            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public static void del(talk talk) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "delete from talk where id=?";
            ps = conn.prepareStatement(sql);
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.free(null,ps,conn);
        }
    }

    public static talk findid(int id) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        talk talk = null;

        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM talk where id=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs.next()){
                talk = new talk();
                talk.setId(rs.getInt(1));
                talk.setKey(rs.getString(2));
                talk.setValue(rs.getString(3));
                talk.setPower(rs.getString(4));
                talk.setFrom(rs.getString(5));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }
        return talk;
    }

    public static List<talk> findkey(talk talk) throws SQLException{
        String key = talk.getKey();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<talk> talks = new ArrayList<talk>();

        try {
            conn = JdbcUtil.getConnection();
            String sql = "SELECT * FROM talk where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,key);
            rs = ps.executeQuery();
            while (rs.next()){
                talk talk1 = new talk();
                talk1.setId(rs.getInt(1));
                talk1.setKey(rs.getString(2));
                talk1.setValue(rs.getString(3));
                talk1.setPower(rs.getString(4));
                talk1.setFrom(rs.getString(5));
                talks.add(talk1);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtil.free(rs,ps,conn);
        }
        return talks;
    }

    public static void update(talk talk){
        int id = talk.getId();
        Connection conn = null;
        PreparedStatement ps = null;
        int flag;

        try {
            String sql = "update talk set key=?,value=?,power=?,form=?";
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,talk.getKey());
            ps.setString(2,talk.getValue());
            ps.setString(3,talk.getPower());
            ps.setString(4,talk.getFrom());
            flag = ps.executeUpdate();
            if (flag == 0){
                System.out.println("更新出错");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
