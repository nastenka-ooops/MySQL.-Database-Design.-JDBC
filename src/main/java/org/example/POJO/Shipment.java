package org.example.POJO;

import java.util.Date;

public class Shipment {
    private long id;
    private Date date;
    private long supplierId;

    public Shipment() {
    }

    public Shipment(long id, Date date, long supplierId) {
        this.id = id;
        this.date = date;
        this.supplierId = supplierId;
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

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }
}
