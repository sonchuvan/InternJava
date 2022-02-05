package busDriverManagementV2.servive;

import busDriverManagementV2.entity.driving.Driving;
import busDriverManagementV2.entity.driving.RouteDriving;
import busDriverManagementV2.main.Main;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

public class DrivingService {

    public static final String DRIVING_DATA = "driving.dat";

    public void addNewListDriving() {
        System.out.println("Nhập số lượng tài xế cấn phân công tuyến bus");
        do {
            try {
                int drivingNumber = new Scanner(System.in).nextInt();
                if (drivingNumber > 0) {
                    for (int i = 0; i < drivingNumber; i++) {
                        Driving driving = new Driving();
                        driving.inputInfor();
                        Main.drivingList.add(driving);
                    }
                    break;
                }
                System.out.println("Số lượng tài xế phải lớn hơn 0, vui lòng nhập lại");
            } catch (InputMismatchException ex) {
                System.out.println("Số lượng tài xế phải là số nguyên, vui lòng nhập lại");
            }
        } while (true);
        Main.fileUtil.writeDataToFile(Main.busRouteList, DRIVING_DATA);
    }

    public Driving addNewDriving() {
        return new Driving();
    }

    public void sortDrivingByName() {
        Main.drivingList.sort(new Comparator<Driving>() {
            @Override
            public int compare(Driving a, Driving b) {
                return b.getDriver().getFullName().compareTo(a.getDriver().getFullName());
            }
        });
    }

    public void sortByCountBusRoute() {
        Main.drivingList.sort(new Comparator<Driving>() {
            @Override
            public int compare(Driving a, Driving b) {
                return countBusRoute(b) - countBusRoute(a);
            }
        });
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
        for (Driving driving : Main.drivingList) {
            int sum = 0;
            System.out.printf(format, driving.getDriver().getFullName());
            System.out.printf(format, sumRangeForDriver(driving));
            System.out.println();
        }
    }

    public int countBusRoute(Driving driving) {
        return driving.getRouteDrivingList().size();
    }

    public void showListDriving() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Bảng phân công tuyến bus");
        ListIterator<Driving> listIterator = Main.drivingList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().toString());
        }
    }
}
