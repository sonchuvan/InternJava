package busDriverManagement;

import busDriverManagement.busDriver.BusDriver;
import busDriverManagement.busDriver.BusDriverService;
import busDriverManagement.busRoute.BusRoute;
import busDriverManagement.busRoute.BusRouteService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        BusDriverService BDS = new BusDriverService();
        BusRouteService BRS = new BusRouteService();
        Roster roster = new Roster();
        List<BusDriver> busDriverList = new ArrayList<>();
        List<BusRoute> busRouteList = new ArrayList<>();
        List<Roster> rosters = new ArrayList<>();
        int lc = 0;
        do {
            System.out.println("=====================BUS DRIVER MANAGEMENT========================");
            System.out.println("1. Nhập danh sách lái xe");
            System.out.println("2. Nhập danh sách tuyến");
            System.out.println("3. Nhập danh sách phân công cho mỗi lái xe");
            System.out.println("4. Sắp xếp danh sách phân công theo tên lái xe");
            System.out.println("5. Sắp xếp danh sách phân theo số lượng tuyến");
            System.out.println("6. Lập bảng kê tổng khoảng cách chạy xe trong ngày của mỗi lái xe");
            System.out.println("0. Thoát chương trình");
            System.out.println("==================================================================");
            boolean flag;
            do {

                String digit = "[0-6]";
                String input = Main.in.nextLine();
                flag = input.matches(digit);

                if (!flag) {
                    System.out.println("nhập sai!, mời nhập lại");
                    continue;
                }
                lc = Integer.parseInt(input);

            } while (!flag);

            switch (lc) {
                case 1:
                    busDriverList = BDS.inputListBusDriver();
                    FileIO.writeObjectToFile(busDriverList, "busDriver.data");

                    FileIO.readObjectFromFile("busDriver.data").forEach(System.out::println);
                    break;
                case 2:
                    busRouteList = BRS.inputListBusRoute();
                    FileIO.writeObjectToFile(busRouteList, "busRoute.data");
                    FileIO.readObjectFromFile("busRoute.data").forEach(System.out::println);
                    break;
                case 3:
                    rosters = roster.inputListRoster(rosters, busDriverList, busRouteList);
                    FileIO.writeObjectToFile(rosters, "roster.data");
                    System.out.println("Danh sách phân công:\n");
                    FileIO.readObjectFromFile("roster.data").forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Danh sách phân công sau khi sắp xếp");
                    roster.sortByName(rosters);
                    rosters.forEach(System.out::println);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình");
                    break;
            }
        } while (lc != 0);
    }
}
