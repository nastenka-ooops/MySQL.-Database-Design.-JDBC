package org.example.POJO;

public class ShipmentItem {
    private long shipmentId;
    private long productId;
    private int quantity;

    public ShipmentItem() {
    }

    public ShipmentItem(long shipmentId, long productId, int quantity) {
        this.shipmentId = shipmentId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
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
}
