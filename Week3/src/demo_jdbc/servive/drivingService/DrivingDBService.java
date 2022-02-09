package demo_jdbc.servive.drivingService;

import demo_jdbc.connection.OracleConnection;
import demo_jdbc.entity.BusRoute;
import demo_jdbc.entity.Driver;
import demo_jdbc.entity.driving.Driving;
import demo_jdbc.entity.driving.RouteDriving;
import demo_jdbc.main.Main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrivingDBService {


    public void saveDrivingToDB(Driving driving) {
        try (Connection conn = OracleConnection.getJDBCConnection()) {
            List<RouteDriving> busRoutes = driving.getRouteDrivingList();
            String sql = "INSERT INTO driving VALUES(?,?,?)";
            for (RouteDriving r : busRoutes) {
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

    public List<Driving> getListDrivingFromDB() {
        List<Driving> drivingList = new ArrayList<>();
        try (Connection conn = OracleConnection.getJDBCConnection()) {
            List<Integer> driverIdList = getDriverIdList();
            for (int i = 0; i < driverIdList.size(); i++) {
                List<RouteDriving> routeDrivingList = new ArrayList<>();
                String sql = "SELECT * FROM driving where driver_id = " + driverIdList.get(i);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    routeDrivingList.add(new RouteDriving(searchBusRoute(rs.getInt(2)), rs.getInt(3)));
                }
                drivingList.add(new Driving(searchDriver(driverIdList.get(i)), routeDrivingList));
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return drivingList;
    }

    public List<Integer> getDriverIdList() {
        List<Integer> list = new ArrayList<>();
        try (Connection conn = OracleConnection.getJDBCConnection()) {
            String sql = "SELECT distinct driver_id FROM driving";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public BusRoute searchBusRoute(int id) {
        BusRoute busRoute = Main.busRouteDBService.getListBusRouteFromDB().stream()
                .filter(busRoute1 -> id == busRoute1.getRouteID())
                .findAny().
                orElse(null);
        return busRoute;
    }

    public demo_jdbc.entity.Driver searchDriver(int id) {
        Driver driver = Main.driverDBService.getListDriverFromDB().stream()
                .filter(busRoute1 -> id == busRoute1.getDriverId())
                .findAny().
                orElse(null);
        return driver;
    }
}
