import java.time.LocalDate;

public class Robot {

    private String name;
    private String model;
    private String serialNumber;
    private String status;
    private String warehouseLocation;
    private String manufacturer; 
    private int year;
    private double batteryAutonomy;
    private String sensorSuite;
    private String primaryFunction;
    private LocalDate warrantyExpiration;
    private String updateStatus;
    
    public Robot(String serialNumber, String name, String model, String status,
    String warehouseLocation, String manufacturer, int year,
    double batteryAutonomy, String sensorSuite, String primaryFunction,
    LocalDate warrantyExpiration, String updateStatus) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.model = model;
        this.status = status;
        this.warehouseLocation = warehouseLocation;
        this.manufacturer = manufacturer;
        this.year = year;
        this.batteryAutonomy = batteryAutonomy;
        this.sensorSuite = sensorSuite;
        this.primaryFunction = primaryFunction;
        this.warrantyExpiration = warrantyExpiration;
        this.updateStatus = updateStatus;
}

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public void setWarehouseLocation(String warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBatteryAutonomy(double batteryAutonomy) {
        this.batteryAutonomy = batteryAutonomy;
    }

    public void setSensorSuite(String sensorSuite) {
        this.sensorSuite = sensorSuite;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public void setWarrantyExpiration(LocalDate warrantyExpiration) {
        this.warrantyExpiration = warrantyExpiration;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    @Override
    public String toString() {
        return "Serial Number: " + this.serialNumber          
        + "\nName: " + this.name        
        + "\nModel: " + this.model        
        + "\nStatus: " + this.status       
        + "\nWarehouse Location: " + this.warehouseLocation       
        + "\nManufacturer: " + this.manufacturer       
        + "\nYear: " + this.year
        + "\nBattery Autonomy: " + this.batteryAutonomy
        + "\nSensor Suite: " + this.sensorSuite
        + "\nPrimary Function: " + this.primaryFunction
        + "\nWarranty Expiration: " + this.warrantyExpiration
        + "\nUpdate Status: " + this.updateStatus;
        }
}