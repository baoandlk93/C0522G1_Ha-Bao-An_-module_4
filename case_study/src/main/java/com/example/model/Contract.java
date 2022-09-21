package model;

import java.util.Date;

public class Contract {
    private int id;
    private Date startDay;
    private Date endDay;
    private double deposit;
    private int employeeID;
    private int customerID;
    private int facilityID;

    public Contract() {
    }

    public Contract(int id, Date startDay, Date endDay, double deposit, int employeeID, int customerID, int facilityID) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.deposit = deposit;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.facilityID = facilityID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }
}
