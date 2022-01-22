package busDriverManagement;

import busDriverManagement.busDriver.BusDriver;
import busDriverManagement.busRoute.BusRoute;

import java.io.Serializable;
import java.util.*;

public class Roster implements Serializable {

    private BusDriver busDriver;
    private Map<BusRoute,Integer> busRoutes = new HashMap<>();

    private static Optional<BusRoute> checkIdInBusRoute(int id, List<BusRoute> busRouteList){
        return busRouteList.stream().filter(busRoute -> busRoute.getBusRouteId()==id).findAny();
    }
    private boolean checkIdInBusRouteListOfDriver(BusRoute busRoute,Map<BusRoute,Integer> busRoutes){
        if (busRoutes==null) return false;
        return busRoutes.containsKey(busRoute);
    }

    public Roster inputRoster(BusDriver busDriver,List<BusRoute> busRouteList){
        Roster roster = new Roster();
        roster.busDriver = busDriver;
        String temp;
        do {
            System.out.println("Nhập số lượng tuyến của lái xe " + busDriver.getDriverName() + ":");
            temp = Main.in.nextLine();
        }while (!temp.matches("\\d+"));
        int sl = Integer.parseInt(temp);
        for (int i = 0; i < sl; i++) {
            String idTemp;
            BusRoute busRoute;
            do {
                System.out.println("Nhập mã tuyến thứ " + (i + 1) + ":");
                idTemp = Main.in.nextLine();
                if (!idTemp.matches("\\d+")) continue;
                int id = Integer.parseInt(idTemp);
                Optional<BusRoute> ob = checkIdInBusRoute(id,busRouteList);
                if (!ob.isPresent()){
                    System.out.println("Mã không tuyến không tồn tại");
                    continue;
                }
                busRoute = ob.get();
                if (checkIdInBusRouteListOfDriver(busRoute,roster.busRoutes)) {
                    continue;
                }
                break;
            }while (true);
            String numTemp;
            do {
                System.out.println("Nhập số tuyến:");
                numTemp = Main.in.nextLine();
            }while (!numTemp.matches("\\d+"));
            int num = Integer.parseInt(numTemp);
            roster.busRoutes.put(busRoute,num);
        }
        return roster;
    }

    public List<Roster> inputListRoster(List<Roster> rosters,List<BusDriver> busDrivers,List<BusRoute> busRoutes){
        if (busDrivers.isEmpty() || busRoutes.isEmpty()) {
            System.out.println("Chưa nhập tài xế hoặc tuyến bus.");
            return rosters;
        }
        Iterator<BusDriver> iterator = busDrivers.iterator();
        System.out.println("Nhập danh sách phân công");
        while (iterator.hasNext()){
            rosters.add(inputRoster(iterator.next(),busRoutes));
        }
        return rosters;
    }
    public String mapToString(Map<BusRoute,Integer> busRoutes){
        StringBuilder temp= new StringBuilder("\n\t");
        for (BusRoute key : busRoutes.keySet()) {
            temp.append(key + "Số lượt: " + busRoutes.get(key) + "\n\t");
        }
        return temp.toString();
    }
    @Override
    public String toString() {
        return "Tài xế: " + busDriver.getDriverName() +
                "\nTuyến: " +"\t"+ mapToString(busRoutes);
    }

    public static void main(String[] args) {
        List<BusRoute> busRoutes = new ArrayList<>();
        busRoutes.add(new BusRoute(1,1));
        busRoutes.add(new BusRoute(2,2));
        busRoutes.add(new BusRoute(3,3));

        Optional<BusRoute> n = busRoutes.stream().filter(busRoute -> busRoute.getBusRouteId()==10).findAny();

        if(n.isPresent())System.out.println(n);
    }

    public List<Roster> sortByName(List<Roster> rosters){
        Collections.sort(rosters, Comparator.comparing((Roster r) -> r.busDriver.getDriverName()));
        return rosters;
    }
}
