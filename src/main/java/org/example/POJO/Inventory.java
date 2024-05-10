package org.example.POJO;

import java.util.Date;

public class Inventory {
    private long flowerId;
    private int quantity;
    private Date dateOfShipment;

    public Inventory() {
    }

    public Inventory(long flowerId, int quantity, Date dateOfShipment) {
        this.flowerId = flowerId;
        this.quantity = quantity;
        this.dateOfShipment = dateOfShipment;
    }

    public long getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(long flowerId) {
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
