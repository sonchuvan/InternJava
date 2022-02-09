package demo_jdbc.servive.driverService;

import demo_jdbc.connection.OracleConnection;
import demo_jdbc.entity.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDBService {
    public void saveDriverToDB(Driver driver) {
        Connection conn = OracleConnection.getJDBCConnection();
        String sql = "INSERT INTO driver VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, driver.getDriverId());
            statement.setString(2, driver.getFullName());
            statement.setString(3, driver.getAddress());
            statement.setString(4, driver.getPhone());
            statement.setString(5, driver.getLevel());
            statement.executeUpdate();
            conn.commit();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Driver> getListDriverFromDB(){
        List<Driver> driverList = new ArrayList<>();
        try (Connection conn = OracleConnection.getJDBCConnection()){
            String sql = "SELECT * FROM driver";
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()){
                    driverList.add(new Driver(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverList;
    }

    public int getMaxId() {
        int maxId = 10000;
        try(Connection conn = OracleConnection.getJDBCConnection()) {
            String sql = "select max(driver_id) from driver";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                maxId = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }
}
