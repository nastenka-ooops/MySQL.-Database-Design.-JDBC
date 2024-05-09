package org.example;

import java.util.Date;

public class Shipment {
    private int id;
    private Date date;
    private int supplierId;

    public Shipment() {
    }

    public Shipment(int id, Date date, int supplierId) {
        this.id = id;
        this.date = date;
        this.supplierId = supplierId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
