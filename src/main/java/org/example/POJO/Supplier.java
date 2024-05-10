package org.example.POJO;

public class Supplier {
    private long id;
    private String companyName;
    private String address;
    private String phone;
    private String email;

    public Supplier() {
    }

    public Supplier(long id, String companyName, String address, String phone, String email) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
