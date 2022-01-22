package busDriverManagement.busRoute;

import java.io.Serializable;

public class BusRoute implements Serializable {
    private static int count = 100;
    private int busRouteId;
    private float range;
    private int numberOfStops;

    public int getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(int busRouteId) {
        this.busRouteId = busRouteId;
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
        this.busRouteId = count++;
        this.range = range;
        this.numberOfStops = numberOfStops;
    }

    @Override
    public String toString() {
        return "BusRoute{" +
                "busRouteId=" + busRouteId +
                ", range=" + range +
                ", numberOfStops=" + numberOfStops +
                '}';
    }
}
