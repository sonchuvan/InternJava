package demo_jdbc.entity;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BusRoute implements Serializable {

    public static int COUNT;
    private int routeID;
    private float range;
    private int numberOfStops;

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }

    public BusRoute() {
    }

    public BusRoute(float range, int numberOfStops) {
        this.range = range;
        this.numberOfStops = numberOfStops;
    }

    public BusRoute(int routeID, float range, int numberOfStops) {
        this.routeID = routeID;
        this.range = range;
        this.numberOfStops = numberOfStops;
    }

    @Override
    public String toString() {
        return "Mã tuyến: " + routeID +
                ", Khoảng cách: " + range +
                ", Số điểm dừng: " + numberOfStops;
    }

    public void inputInfor(){
        this.routeID = COUNT;
        System.out.println("Nhập thông tin tuyến bus có mã "+this.getRouteID());
        COUNT++;
        System.out.println("Nhập khoảng cách của tuyến bus(km): ");
        do {
            try {
                float range = new Scanner(System.in).nextFloat();
                if (range > 0){
                    this.range = range;
                    break;
                }
                System.out.println("Khoảng cách phải lớn hơn 0, vui lòng nhập lại");
            }catch (InputMismatchException ex){
                System.out.println("Khoảng cách phải là sô thực, vui lòng nhập lại.");
            }
        }while (true);
        System.out.println("Nhập số điểm dừng: ");
        do {
            try {
                int stopNumber = new Scanner(System.in).nextInt();
                if (stopNumber > 0){
                    this.numberOfStops = stopNumber;
                    break;
                }
                System.out.println("Số điểm dừng phải lớn hơn 0, vui lòng nhập lại");
            }catch (InputMismatchException ex){
                System.out.println("Số điểm dừng phải là số nguyên, vui lòng nhập lại.");
            }
        }while (true);
    }
}
