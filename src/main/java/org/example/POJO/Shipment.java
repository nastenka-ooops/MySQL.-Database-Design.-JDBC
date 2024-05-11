package org.example.POJO;

import java.sql.Date;

public class Shipment {
    private long id;
    private Date date;
    private long supplierId;
    private Status status;

    public Shipment() {
    }

    public Shipment(long id, Date date, long supplierId, Status status) {
        this.id = id;
        this.date = date;
        this.supplierId = supplierId;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

