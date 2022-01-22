package busDriverManagement.busDriver;

import java.io.Serializable;

public class BusDriver implements Serializable {
    private static int cont = 10000;
    private int driverId;
    private String driverName;
    private String driverAddress;
    private String driverPhone;
    private String driverLevel;

    public int getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverAddress() {
        return driverAddress;
    }

    public void setDriverAddress(String driverAddress) {
        this.driverAddress = driverAddress;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverLevel() {
        return driverLevel;
    }

    public void setDriverLevel(String driverLevel) {
        this.driverLevel = driverLevel;
    }

    public BusDriver() {
        //this.driverId = cont++;
    }

    public BusDriver(String driverName, String driverAddress, String driverPhone, String driverLevel) {
        this.driverId = cont++;
        this.driverName = driverName;
        this.driverAddress = driverAddress;
        this.driverPhone = driverPhone;
        this.driverLevel = driverLevel;
    }

    @Override
    public String toString() {
        return "BusDriver{" +
                "driverId='" + driverId + '\'' +
                ", driverName='" + driverName + '\'' +
                ", driverAddress='" + driverAddress + '\'' +
                ", driverPhone='" + driverPhone + '\'' +
                ", driverLevel='" + driverLevel + '\'' +
                '}';
    }
}
