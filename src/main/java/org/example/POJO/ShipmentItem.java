package org.example.POJO;

public class ShipmentItem {
    private long shipmentId;
    private long flowerId;
    private int quantity;

    public ShipmentItem() {
    }

    public ShipmentItem(long shipmentId, long flowerId, int quantity) {
        this.shipmentId = shipmentId;
        this.flowerId = flowerId;
        this.quantity = quantity;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
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
}
