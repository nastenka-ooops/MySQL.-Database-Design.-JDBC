package org.example;

public class OrderItem {
    private int orderId;
    private int flowerId;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(int orderId, int flowerId, int quantity) {
        this.orderId = orderId;
        this.flowerId = flowerId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
