package busDriverManagementV2.entity.driving;

import busDriverManagementV2.entity.BusRoute;

import java.io.Serializable;

public class RouteDriving implements Serializable {
    private BusRoute busRoute;
    private int routeQuantity;

    public BusRoute getRoute() {
        return busRoute;
    }

    public void setRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    public int getRouteQuantity() {
        return routeQuantity;
    }

    public void setRouteQuantity(int routeQuantity) {
        this.routeQuantity = routeQuantity;
    }

    public RouteDriving(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    public RouteDriving(BusRoute busRoute, int routeQuantity) {
        this.busRoute = busRoute;
        this.routeQuantity = routeQuantity;
    }


}
