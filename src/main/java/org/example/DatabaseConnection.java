package org.example;

import org.example.DAO.*;
import org.example.POJO.*;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class DatabaseConnection {
    public static Connection connection = null;
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/flower_shop";
        String username = "root";
        String password = "n3a0s1t2ia";
        try{
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Соединение успешно установлено!");

//            ProductDao productDao = new ProductDao();
//            productDao.create(new Product(3,"cornflower", 30, new BigDecimal("0.5")));
//            productDao.read(3);
//            productDao.update(2, new Product(2, "pion", 10, new BigDecimal("1")));
//            productDao.delete(3);

            /*CompatibilityDao compatibilityDao = new CompatibilityDao();
            compatibilityDao.create(new Compatibility(3,2,1));
            compatibilityDao.read(2,3);
            compatibilityDao.update(2,3,new Compatibility(2,3,0.5));
            compatibilityDao.delete(3,2);
            */
/*
            CustomerDao customerDao = new CustomerDao();
            customerDao.create(new Customer(1,"anasty", "shmasty","d", "f", "s"));
            customerDao.create(new Customer(2,"anasty", "shmasty","d", "p", "e"));
            customerDao.update(2,new Customer(2,"anasty", "shmasty","d", "y", "r"));
            customerDao.read(1);
            customerDao.delete(2);*/

            /*EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.create(new Employee(3, "anasty", "shmasty", "admin", new BigDecimal(1000), new Date(System.currentTimeMillis())));
            employeeDao.create(new Employee(2, "anasty", "shmasty", "admin", new BigDecimal(1000), new Date(System.currentTimeMillis())));
            employeeDao.read(2);
            employeeDao.update(1, new Employee(1, "anasty", "shmasty", "waiter", new BigDecimal(1000), new Date(System.currentTimeMillis())));
            employeeDao.delete(2);*/

            /*InventoryDao inventoryDao = new InventoryDao();
            inventoryDao.create(new Inventory(2, 10, new Date(System.currentTimeMillis())));
            inventoryDao.create(new Inventory(3, 15, new Date(System.currentTimeMillis())));
            inventoryDao.read(2);
            inventoryDao.update(3, new Inventory(3, 13, new Date(System.currentTimeMillis())));
            inventoryDao.delete(2);
*/

//            OrderDao orderDao = new OrderDao();
//            orderDao.create(new Order(1, new Date(System.currentTimeMillis()), 1, Status.CHECKOUT));
//            /*orderDao.create(new Order(2, new Date(System.currentTimeMillis()), 1, Status.PAID));
//            orderDao.read(2);
//            orderDao.update(2, new Order(2, new Date(System.currentTimeMillis()), 1, Status.FULFILLED));
//            orderDao.delete(1);


            /*OrderItemDao orderItemDao = new OrderItemDao();
            orderItemDao.create(new OrderItem(1, 2, 4));
            orderItemDao.create(new OrderItem(1, 3, 3));
            orderItemDao.create(new OrderItem(2, 3, 3));
            orderItemDao.read(1,2);
            orderItemDao.update(1,3,new OrderItem(1,3,5));
            orderItemDao.delete(2,3);
*/

//            SupplierDao supplierDao = new SupplierDao();
//            supplierDao.create(new Supplier(1, "flowers", "adr", "num", "em"));
//            supplierDao.create(new Supplier(2, "flowers", "adr", "number", "email"));
//            supplierDao.read(2);
//            supplierDao.update(1, new Supplier(1, "flow", "adr", "num", "em"));
//            supplierDao.delete(2);

//            ShipmentDao shipmentDao = new ShipmentDao();
//            shipmentDao.create(new Shipment(1, new Date(System.currentTimeMillis()), 1, Status.CHECKOUT));
//            shipmentDao.create(new Shipment(2, new Date(System.currentTimeMillis()), 1, Status.PAID));
//            shipmentDao.read(2);
//            shipmentDao.update(2, new Shipment(2, new Date(System.currentTimeMillis()), 1, Status.FULFILLED));
//            shipmentDao.delete(1);

//            ShipmentDao shipmentDao = new ShipmentDao();
//            shipmentDao.create(new Shipment(1, new Date(System.currentTimeMillis()), 1, Status.CHECKOUT));


//            ShipmentItemDao shipmentItemDao = new ShipmentItemDao();
//            shipmentItemDao.create(new ShipmentItem(1, 2, 4));
//            shipmentItemDao.create(new ShipmentItem(1, 3, 3));
//            shipmentItemDao.create(new ShipmentItem(2, 3, 3));
//            shipmentItemDao.read(1,2);
//            shipmentItemDao.update(1,3,new ShipmentItem(1,3,5));
//            shipmentItemDao.delete(2,3);

            connection.close();
        } catch (SQLException e) {
            System.out.println("Соединение не установлено!");
        }
    }
}
