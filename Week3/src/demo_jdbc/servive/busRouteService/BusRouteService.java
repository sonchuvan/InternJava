package demo_jdbc.servive.busRouteService;

import demo_jdbc.entity.BusRoute;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BusRouteService {

    BusRouteDBService busRouteDBService = new BusRouteDBService();
    public static final String BUS_ROUTE_DATA = "busroute.dat";

    public void addNewListBusRoute() {
        System.out.println("Nhập số tuyến bus muốn thêm:");
        do {
            try {
                int number = new Scanner(System.in).nextInt();
                if (number > 0) {
                    for (int i = 0; i < number; i++) {
                        BusRoute busRoute = addNewBusRoute();
                        busRouteDBService.saveBusRouteToDB(busRoute);
                    }
                    break;
                }
                System.out.println("Số tuyến bus phải lớn hơn 0, vui lòng nhập lại.");
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng tuyến bus phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    public BusRoute addNewBusRoute() {
        BusRoute busRoute = new BusRoute();
        busRoute.inputInfor();
        return busRoute;
    }

    public void showListBusRoute() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Danh sách tuyến xe");
        List<BusRoute> busRouteList = busRouteDBService.getListBusRouteFromDB();
        for (BusRoute busRoute : busRouteList) {
            System.out.println(busRoute.toString());
        }
    }
}
