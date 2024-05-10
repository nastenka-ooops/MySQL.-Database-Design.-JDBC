package org.example.POJO;

public class OrderItem {
    private long orderId;
    private long flowerId;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(long orderId, long flowerId, int quantity) {
        this.orderId = orderId;
        this.flowerId = flowerId;
        this.quantity = quantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
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
