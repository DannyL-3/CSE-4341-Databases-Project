import java.time.LocalDate;

public class Customer {
    private String name;
    private String fName;
    private String lName;
    private String Address;
    private String phoneNumber;
    private String email;
    private LocalDate startDate;
    private double facilityDistance;
    private String userID;
    private String status;

    public Customer(String userID, String name, String fName, String lName,
            String Address, String phoneNumber, String email,
            LocalDate startDate, double facilityDistance, String status) {
        this.userID = userID;
        this.name = name;
        this.fName = fName;
        this.lName = lName;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startDate = startDate;
        this.facilityDistance = facilityDistance;
        this.status = status;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setFacilityDistance(double facilityDistance) {
        this.facilityDistance = facilityDistance;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {   
        return "User ID: " + this.userID        
        + "\nName: " + this.name        
        + "\nFirst Name: " + this.fName
        + "\nLast Name: " + this.lName
        + "\nAddress: " + this.Address
        + "\nPhone Number: " + this.phoneNumber
        + "\nEmail: " + this.email
        + "\nStart Date: " + this.startDate
        + "\nFacility Distance: " + this.facilityDistance
        + "\nStatus: " + this.status;
    }
}
