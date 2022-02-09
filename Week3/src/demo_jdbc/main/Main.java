package demo_jdbc.main;

import demo_jdbc.entity.BusRoute;
import demo_jdbc.entity.Driver;
import demo_jdbc.servive.busRouteService.BusRouteDBService;
import demo_jdbc.servive.busRouteService.BusRouteService;
import demo_jdbc.servive.driverService.DriverDBService;
import demo_jdbc.servive.driverService.DriverService;
import demo_jdbc.servive.drivingService.DrivingDBService;
import demo_jdbc.servive.drivingService.DrivingService;
import demo_jdbc.util.file.FileUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static BusRouteDBService busRouteDBService = new BusRouteDBService();
    public static DriverDBService driverDBService  = new DriverDBService();
    public static DrivingDBService drivingDBService = new DrivingDBService();

    public static DrivingService drivingService = new DrivingService();
    public static DriverService driverService = new DriverService();
    public static BusRouteService busRouteService = new BusRouteService();

    public static FileUtil fileUtil = new FileUtil();

    public static void main(String[] args) {
        initializeData();
        menu();
    }

    private static void initializeData(){
        if (driverDBService.getListDriverFromDB().size()!=0){
            Driver.COUNT = driverDBService.getMaxId()+1;
        }
        else {
            Driver.COUNT = 10000;
        }
        if (driverDBService.getListDriverFromDB().size()!=0){
            BusRoute.COUNT = driverDBService.getMaxId()+1;
        }
        else {
            BusRoute.COUNT = 100;
        }

    }

    public static int choice() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("QUẢN LÝ PHÂN CÔNG LÁI XE BUS");
        System.out.println("1. Nhập danh sách lái xe mới và in ra danh sách lái xe");
        System.out.println("2. Nhập danh sách tuyến xe và in ra danh sách tuyến xe");
        System.out.println("3. Nhập danh sách phân công cho mỗi lái xe");
        System.out.println("4. Sắp xếp danh sách phân công theo tên lái xe");
        System.out.println("5. sắp xếp danh sách theo số lượng tuyến đảm nhiệm trong ngày");
        System.out.println("6. Lập bảng thống kê khoảng cách chạy xe của mỗi lái xe");
        System.out.println("0. kết thúc chương trình");
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mời chọn chức năng");
        do {
            try {
                int choice = new Scanner(System.in).nextInt();
                if (choice >= 0 && choice <= 6){
                    return choice;
                }
                System.out.println("vui lòng nhập lại lựa chọn là một số nguyên từ 0 đến 6");
            } catch (InputMismatchException ex) {
                System.out.println("Chức năng phải là một số nguyên, vui lòng nhập lại");
            }
        } while (true);
    }

    public static void menu(){
        do {
            int choice = choice();
            switch (choice){
                case 1:
                    driverService.addNewListDriver();
                    driverService.showListDriver();
                    break;
                case 2:
                    busRouteService.addNewListBusRoute();
                    busRouteService.showListBusRoute();
                    break;
                case 3:
                    if(driverDBService.getListDriverFromDB().size()==0){
                        System.out.println("Chưa có thông tin tài xế nào, vui lòng nhập thông tin tài xế.");
                        break;
                    }
                    if(busRouteDBService.getListBusRouteFromDB().size()==0){
                        System.out.println("Chưa có thông tin tuyến bus nào, vui lòng nhập thông tin tuyến bus.");
                        break;
                    }
                    drivingService.addNewListDriving();
                    drivingService.showListDriving(drivingDBService.getListDrivingFromDB());
                    break;
                case 4:
                    System.out.println("Sắp xếp bảng phân công theo tên tài xế");
                    drivingService.showListDriving(drivingService.sortDrivingByName());
                    break;
                case 5:
                    System.out.println("Sắp xếp bảng phân công theo tổng số tuyến");
                    drivingService.showListDriving(drivingService.sortByCountBusRoute());
                    break;
                case 6:
                    drivingService.showSumRangeForDriver();
                    break;
                case 0:
                    System.exit(0);
            }
        }while (true);
    }
}
