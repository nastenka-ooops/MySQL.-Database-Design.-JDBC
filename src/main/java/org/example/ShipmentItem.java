package org.example;

public class ShipmentItem {
    private int shipmentId;
    private int flowerId;
    private int quantity;

    public ShipmentItem() {
    }

    public ShipmentItem(int shipmentId, int flowerId, int quantity) {
        this.shipmentId = shipmentId;
        this.flowerId = flowerId;
        this.quantity = quantity;
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
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
}
