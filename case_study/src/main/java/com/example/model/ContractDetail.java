package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int contractID;
    private int attachFacilityID;
    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int id, int contractID, int attachFacilityID, int quantity) {
        this.id = id;
        this.contractID = contractID;
        this.attachFacilityID = attachFacilityID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public int getAttachFacilityID() {
        return attachFacilityID;
    }

    public void setAttachFacilityID(int attachFacilityID) {
        this.attachFacilityID = attachFacilityID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
