package org.example.POJO;

import java.sql.Date;

public class Inventory {
    private long productId;
    private int quantity;
    private Date shipmentDate;

    public Inventory() {
    }

    public Inventory(long productId, int quantity, Date shipmentDate) {
        this.productId = productId;
        this.quantity = quantity;
        this.shipmentDate = shipmentDate;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
}
