package demo_jdbc.servive.driverService;

import demo_jdbc.entity.Driver;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService {

    DriverDBService driverDBService = new DriverDBService();

    public void addNewListDriver() {
        int driverNumber = -1;
        System.out.println("Nhập số lượng lái xe: ");
        do {
            try {
                driverNumber = new Scanner(System.in).nextInt();
                if (driverNumber > 0) {
                    break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("số lượng lái xe phải là số nguyên, vui lòng nhập lại.");
            }
        } while (true);
        for (int i = 0; i < driverNumber; i++) {
            Driver driver = addNewDriver();
            driverDBService.saveDriverToDB(driver);
        }
        //Main.fileUtil.writeDataToDB(Main.driverList,DRIVER_DATA);
    }
    public Driver addNewDriver() {
        Driver driver = new Driver();
        driver.inputInfor();
        return driver;
    }

    public void showListDriver() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Danh sách lái xe");
        List<Driver> driverList = driverDBService.getListDriverFromDB();
        for (Driver driver : driverList) {
            System.out.println(driver.toString());
        }
    }
}
