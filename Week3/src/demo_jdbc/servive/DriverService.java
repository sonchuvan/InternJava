package demo_jdbc.servive;

import demo_jdbc.entity.Driver;
import demo_jdbc.main.Main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DriverService {
    public static final String DRIVER_DATA ="driver.dat";
    public List<Driver> driverList;
    DBService dbService = new DBService();

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
            addDriverToList(driver);
            dbService.saveDriverToDB(driver);
        }
        //Main.fileUtil.writeDataToDB(Main.driverList,DRIVER_DATA);
    }
    public Driver addNewDriver() {
        Driver driver = new Driver();
        driver.inputInfor();
        return driver;
    }

    public void addDriverToList(Driver driver) {
        Main.driverList.add(driver);
    }

    public void showListDriver() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("Danh sách lái xe");
        for (Driver driver : Main.driverList) {
            System.out.println(driver.toString());
        }
    }
}
