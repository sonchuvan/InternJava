package demo_jdbc.entity.driving;

import demo_jdbc.entity.BusRoute;
import demo_jdbc.entity.Driver;
import demo_jdbc.main.Main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Driving implements Serializable {
    private Driver driver;
    private List<RouteDriving> routeDrivingList = new ArrayList<>();

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<RouteDriving> getRouteDrivingList() {
        return routeDrivingList;
    }

    public void setRouteDrivingList(List<RouteDriving> routeDrivingList) {
        this.routeDrivingList = routeDrivingList;
    }

    public Driving() {
    }

    public Driving(Driver driver, List<RouteDriving> routeDrivingList) {
        this.driver = driver;
        this.routeDrivingList = routeDrivingList;
    }

    public void inputInfor() {
        System.out.println("Nhập mã tài xế cần phân công: ");
        int driverID;
        do {
            try {
                driverID = new Scanner(System.in).nextInt();
                if (checkDriverFromDrivingList(driverID)) {
                    System.out.println("Tài xế này đã được phân công, vui lòng chọn tài xế khác.");
                    continue;
                }
                if (checkDriverFromDriverList(driverID)) {
                    this.driver = getDriverByID(driverID);
                    break;
                }
                System.out.println("Mã tại xế không tồn tại, vui lòng nhập lại");
            } catch (InputMismatchException ex) {
                System.out.println("mã tài xế phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
        System.out.println("Bạn đã chọn tài xế: "+Main.drivingDBService.searchDriver(driverID).getFullName());
        System.out.println("Nhập số lượng tuyến bus được phân công của tài xế: ");
        do {
            try {
                int busRouteNumber = new Scanner(System.in).nextInt();
                if (busRouteNumber <= 0) {
                    System.out.println("Số lượng tuyến phải lớn hơn 0, vui lòng nhập lại");
                    continue;
                }
                addNewListRouteDriving(busRouteNumber);
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng tuyến bus phải là số nguyên, vui lòng nhập lại.");
            }
        } while (true);
    }

    public int inputNumberOfRoute() {
        int number = -1;
        do {
            try {
                number = new Scanner(System.in).nextInt();
                if (number <= 0) {
                    System.out.println("Số lượng chuyến phải lớn hơn 0, vui lòng nhập lại");
                    continue;
                }
                if (totalRouteQuantity()+number >= 15) {
                    System.out.println("đã quá số lượt quy định");
                    continue;
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng chuyến phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
        return number;
    }

    public void addNewListRouteDriving(int busRouteNumber) {
        for (int i = 0; i < busRouteNumber; i++) {
            if(totalRouteQuantity() >=15){
                System.out.println("Số lượt đã lớn hơn 15, không thể phân công thêm.");
                break;
            }
            System.out.println("Nhập mã tuyến được phân công cho tài xế: ");
            do {
                try {
                    int busRouteID = new Scanner(System.in).nextInt();
                    if (!checkBusRouteFromList(busRouteID)) {
                        System.out.println("Mã tuyến không tồn tại, vui lòng nhập lại");
                        continue;
                    }
                    if (checkBusRouteFromDriver(busRouteID)) {
                        System.out.println("Đã nhập mã tuyến này, vui lòng chọn mã khác");
                        continue;
                    }
                    System.out.println("tài xế " + this.driver.getFullName() + " đã có " + totalRouteQuantity());
                    System.out.println("Nhập số lượt của tuyến bus vừa nhập");
                    int number = inputNumberOfRoute();
                    routeDrivingList.add(new RouteDriving(getBusRouteByID(busRouteID), number));
                    break;
                } catch (InputMismatchException ex) {
                    System.out.println("mã tuyến phải là số nguyên, vui long nhập lại");
                }
            } while (true);
        }
    }

    public int totalRouteQuantity() {
        int total = 0;
        for (RouteDriving r : routeDrivingList) {
            total += r.getRouteQuantity();
        }
        return total;
    }

    public boolean checkBusRouteFromList(int busRouteID) {
        for (BusRoute busRoute : Main.busRouteDBService.getListBusRouteFromDB()) {
            if (busRoute.getRouteID() == busRouteID) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBusRouteFromDriver(int busRouteID) {
        for (RouteDriving routeDriving : this.routeDrivingList) {
            if (routeDriving.getBusRoute().getRouteID() == busRouteID) {
                return true;
            }
        }
        return false;
    }

    public BusRoute getBusRouteByID(int busRouteID) {
        BusRoute busRouteTemp = new BusRoute();
        for (BusRoute busRoute : Main.busRouteDBService.getListBusRouteFromDB()) {
            if (busRoute.getRouteID() == busRouteID) {
                busRouteTemp = busRoute;
                return busRouteTemp;
            }
        }
        return busRouteTemp;
    }

    public boolean checkDriverFromDriverList(int driverID) {
        for (Driver driver : Main.driverDBService.getListDriverFromDB()) {
            if (driver.getDriverId() == driverID) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDriverFromDrivingList(int id) {
        for (Driving driving : Main.drivingDBService.getListDrivingFromDB()) {
            if (driving.driver.getDriverId() == id) {
                return true;
            }
        }
        return false;
    }

    public Driver getDriverByID(int driverID) {
        Driver driverTemp = new Driver();
        for (Driver driver : Main.driverDBService.getListDriverFromDB()) {
            if (driver.getDriverId() == driverID) {
                driverTemp = driver;
                return driverTemp;
            }
        }
        return driverTemp;
    }

    public String showListRouteDriving(List<RouteDriving> routeDriving) {
        String s = "";
        for (RouteDriving r : routeDriving) {
            s += ("\n\t\t mã tuyến: " + r.getBusRoute().getRouteID() + " Số lượng chuyến: " + r.getRouteQuantity());
        }
        return s;
    }

    @Override
    public String toString() {
        return "Tài xế: " + driver.getFullName() +
                ", Danh sách tuyến:" +
                showListRouteDriving(routeDrivingList);
    }
}
