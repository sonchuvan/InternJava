package demo_jdbc.servive.drivingService;

import demo_jdbc.entity.driving.Driving;
import demo_jdbc.entity.driving.RouteDriving;
import demo_jdbc.main.Main;

import java.util.*;

public class DrivingService {

    DrivingDBService drivingDBService = new DrivingDBService();
    public static final String DRIVING_DATA = "driving.dat";

    public void addNewListDriving() {
        int temp = Main.driverDBService.getListDriverFromDB().size() - Main.drivingDBService.getListDrivingFromDB().size();
        if (temp == 0){
            System.out.println("Tất cả tài xế đã được phân công");
            return;
        }
        System.out.println("Số tài xế chưa được phân công tuyến bus là: "+temp);
        System.out.println("Nhập số lượng tài xế cấn phân công tuyến bus");
        do {
            try {
                int drivingNumber = new Scanner(System.in).nextInt();
                if (drivingNumber > temp ){
                    System.out.println("Số lượng muốn phân công đã vượt quá số lượng tài xế chưa được phân công, mời nhập lại");
                    continue;
                }
                if (drivingNumber > 0) {
                    for (int i = 0; i < drivingNumber; i++) {
                        Driving driving = new Driving();
                        driving.inputInfor();
                        drivingDBService.saveDrivingToDB(driving);
                    }
                    break;
                }
                System.out.println("Số lượng tài xế phải lớn hơn 0, vui lòng nhập lại");
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng tài xế phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
        //Main.fileUtil.writeDataToDB(Main.busRouteList, DRIVING_DATA);
    }

    public Driving addNewDriving() {
        return new Driving();
    }

    public List<Driving> sortDrivingByName() {
        List<Driving> drivingList = Main.drivingDBService.getListDrivingFromDB();
        drivingList.sort(new Comparator<Driving>() {
            @Override
            public int compare(Driving a, Driving b) {
                return b.getDriver().getFullName().compareTo(a.getDriver().getFullName());
            }
        });
        return drivingList;
    }

    public List<Driving> sortByCountBusRoute() {
        List<Driving> drivingList = Main.drivingDBService.getListDrivingFromDB();
        drivingList.sort(new Comparator<Driving>() {
            @Override
            public int compare(Driving a, Driving b) {
                return countBusRoute(b) - countBusRoute(a);
            }
        });

        return drivingList;
    }

    public int sumRangeForDriver(Driving driving) {
        int sum = 0;
        for (RouteDriving r : driving.getRouteDrivingList()) {
            sum += r.getRouteQuantity();
        }
        return sum;
    }

    public void showSumRangeForDriver() {
        String format = "%10s";
        System.out.println("Bảng kê tổng khoảng cách chạy xe của mỗi tài xế trong một ngày");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%10s","Tài xế");
        System.out.println("\t\tkhoảng cách");
        for (Driving driving : Main.drivingDBService.getListDrivingFromDB()) {
            int sum = 0;
            System.out.printf(format, driving.getDriver().getFullName());
            System.out.printf(format, sumRangeForDriver(driving));
            System.out.println();
        }
    }

    public int countBusRoute(Driving driving) {
        return driving.getRouteDrivingList().size();
    }

    public void showListDriving(List<Driving> drivingList) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bảng phân công tuyến bus");
        ListIterator<Driving> listIterator = drivingList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
        }
    }
}
