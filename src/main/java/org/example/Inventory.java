package org.example;

import java.util.Date;

public class Inventory {
    private int flowerId;
    private int quantity;
    private Date dateOfShipment;

    public Inventory() {
    }

    public Inventory(int flowerId, int quantity, Date dateOfShipment) {
        this.flowerId = flowerId;
        this.quantity = quantity;
        this.dateOfShipment = dateOfShipment;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(Date dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }
}
