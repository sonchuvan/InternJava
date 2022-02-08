package demo_jdbc.servive;

import demo_jdbc.entity.BusRoute;
import demo_jdbc.main.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BusRouteService {

    DBService dbService = new DBService();
    public static final String BUS_ROUTE_DATA = "busroute.dat";

    public void addNewListBusRoute() {
        System.out.println("Nhập số tuyến bus muốn thêm:");
        do {
            try {
                int number = new Scanner(System.in).nextInt();
                if (number > 0) {
                    for (int i = 0; i < number; i++) {
                        BusRoute busRoute = addNewBusRoute();
                        addBusRouteToList(busRoute);
                        dbService.saveBusRouteToDB(busRoute);
                    }
                    break;
                }
                System.out.println("Số tuyến bus phải lớn hơn 0, vui lòng nhập lại.");
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng tuyến bus phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
        //Main.fileUtil.writeDataToDB(Main.busRouteList,BUS_ROUTE_DATA);
    }

    public BusRoute addNewBusRoute() {
        BusRoute busRoute = new BusRoute();
        busRoute.inputInfor();
        return busRoute;
    }

    public void addBusRouteToList(BusRoute busRoute) {
        Main.busRouteList.add(busRoute);
    }

    public void showListBusRoute() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Danh sách tuyến xe");
        for (BusRoute busRoute : Main.busRouteList) {
            System.out.println(busRoute.toString());
        }
    }
}
