package demo_jdbc.main;

import demo_jdbc.connection.OracleConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStament {
    public static void main(String[] args) {
        try {
            Connection conn = OracleConnection.getJDBCConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from driver";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("driver_id");
                String name = rs.getString(2);
                String address = rs.getString(3);
                String phone = rs.getString(4);
                String level = rs.getString(5);
                System.out.println("driver: "+id +", "+name+", "+level);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
