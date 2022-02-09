package demo_jdbc.servive.busRouteService;

import demo_jdbc.connection.OracleConnection;
import demo_jdbc.entity.BusRoute;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BusRouteDBService {
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
}
