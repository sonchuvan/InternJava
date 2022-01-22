package busDriverManagement.busDriver;

import busDriverManagement.Main;

import java.util.ArrayList;
import java.util.List;

public class BusDriverService {

    private BusDriver inptBusDriver(){
        //BusDriver busDriver = new BusDriver();
        System.out.println("Nhập thông tin lái xe:");
        System.out.println("Nhập tên lái xe:");
        String busDriverName = Main.in.nextLine();
        System.out.println("Nhập địa chỉ:");
        String busDriverAddress = Main.in.nextLine();
        System.out.println("Nhập số điện thoại:");
        String busDriverPhone = Main.in.nextLine();
        String busDriverLevel;
        do {
            System.out.println("Nhập trình độ(A-F):");
            busDriverLevel = Main.in.nextLine();
        } while (!busDriverLevel.matches("[A-F]"));
        return new BusDriver(busDriverName,busDriverAddress,busDriverPhone,busDriverLevel);
    }

    public List<BusDriver> inputListBusDriver(){
        List<BusDriver> busDriverList = new ArrayList<>();
        String temp;
        do {
            System.out.println("Nhập số lượng lái xe:");
            temp = Main.in.nextLine();
        }while (!temp.matches("\\d+"));
        int sl = Integer.parseInt(temp);
        for (int i = 0; i < sl; i++) {
            busDriverList.add(inptBusDriver());
        }
        return busDriverList;
    }
}
