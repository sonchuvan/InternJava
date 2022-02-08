package demo_jdbc.connection;

import demo_jdbc.entity.BusRoute;
import demo_jdbc.entity.Driver;
import demo_jdbc.entity.driving.Driving;
import demo_jdbc.entity.driving.RouteDriving;
import demo_jdbc.main.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBService {
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
        Connection conn = OracleConnection.getJDBCConnection();
        String sql = "SELECT * FROM driver";
        List<Driver> driverList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                driverList.add(new Driver(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverList;
    }

    public void saveBusRouteToDB(BusRoute busRoute) {
        Connection conn = OracleConnection.getJDBCConnection();
        String sql = "INSERT INTO bus_route VALUES(?,?,?)";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, busRoute.getRouteID());
            statement.setFloat(2, busRoute.getRange());
            statement.setInt(3, busRoute.getNumberOfStops());
            statement.executeUpdate();
            conn.commit();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BusRoute> getListBusRouteFromDB(){
        Connection conn = OracleConnection.getJDBCConnection();
        String sql = "SELECT * FROM bus_route";
        List<BusRoute> busRouteList = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                busRouteList.add(new BusRoute(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return busRouteList;
    }

    public void saveDrivingToDB(Driving driving){
        try(Connection conn = OracleConnection.getJDBCConnection()) {
            List<RouteDriving> busRoutes = driving.getRouteDrivingList();
            String sql = "INSERT INTO driving VALUES(?,?,?)";
            for (RouteDriving r: busRoutes ) {
                try {
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setInt(1, driving.getDriver().getDriverId());
                    statement.setInt(2, r.getBusRoute().getRouteID());
                    statement.setInt(3, r.getRouteQuantity());
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Driving> getListDrivingFromDB(){
        List<Driving> drivingList = new ArrayList<>();
        try (Connection conn = OracleConnection.getJDBCConnection()){
            List<Integer> driverIdList = getDriverIdList();
            for (int i = 0; i < driverIdList.size(); i++) {
                List<RouteDriving> routeDrivingList = new ArrayList<>();
                String sql = "SELECT * FROM driving where driver_id = "+driverIdList.get(i);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()){
                    routeDrivingList.add(new RouteDriving(searchBusRoute(rs.getInt(2)),rs.getInt(3)));
                }
                drivingList.add(new Driving(searchDriver(driverIdList.get(i)),routeDrivingList));
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivingList;
    }
    public List<Integer> getDriverIdList(){
        List<Integer> list = new ArrayList<>();
        try (Connection conn = OracleConnection.getJDBCConnection()){
            String sql = "SELECT distinct driver_id FROM driving";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                list.add(rs.getInt(1));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public BusRoute searchBusRoute(int id){

        BusRoute busRoute = Main.busRouteList.stream()
                .filter(busRoute1 -> id == busRoute1.getRouteID())
                .findAny().
                orElse(null);
        return busRoute;
    }
    public Driver searchDriver(int id){
        Driver driver = Main.driverList.stream()
                .filter(busRoute1 -> id == busRoute1.getDriverId())
                .findAny().
                orElse(null);
        return driver;
    }

}
