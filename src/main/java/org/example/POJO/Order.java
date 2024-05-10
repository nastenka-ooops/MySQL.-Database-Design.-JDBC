package org.example.POJO;

import java.util.Date;

public class Order {
    private long id;
    private Date date;
    private long customerId;
    public Order() {
    }

    public Order(long id, Date date, long customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
}
