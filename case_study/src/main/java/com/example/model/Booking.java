package model;

import java.util.Date;

public class Booking {
    private String bookingID;
    private Date begin;
    private Date end;
    private String customerID;
    private String facilityName;
    private String facilityID;

    public Booking() {
    }

    public Booking(String bookingID, Date begin, Date end, String customerID, String facilityName, String facilityID) {
        this.bookingID = bookingID;
        this.begin = begin;
        this.end = end;
        this.customerID = customerID;
        this.facilityName = facilityName;
        this.facilityID = facilityID;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
    }
}
