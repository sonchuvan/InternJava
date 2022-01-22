package busDriverManagement.busRoute;

import busDriverManagement.Main;

import java.util.ArrayList;
import java.util.List;

public class BusRouteService {

    private BusRoute inputBusRoute(){
        String temp;
        do {
            System.out.println("Nhập Khoảng cách:");
            temp = Main.in.nextLine();
        }while (!temp.matches("[0-9]+([.][0-9]+)?"));
        float range = Float.parseFloat(temp);
        do {
            System.out.println("Nhập số điểm dừng:");
            temp = Main.in.nextLine();
        }while (!temp.matches("[0-9]+"));
        int num = Integer.parseInt(temp);
        return new BusRoute(range,num);
    }

    public List<BusRoute> inputListBusRoute(){
        List<BusRoute> busRouteList = new ArrayList<>();
        String temp;
        do {
            System.out.println("Nhập số tuyến bus:");
            temp = Main.in.nextLine();
        }while (!temp.matches("\\d+"));
        int sl = Integer.parseInt(temp);
        for (int i = 0; i < sl; i++) {
            System.out.println("Nhập thông tin tuyến bus thứ "+(i+1));
            busRouteList.add(inputBusRoute());
        }
        return busRouteList;
    }
}
