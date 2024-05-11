package org.example.DAO;

import org.example.POJO.Customer;
import org.example.POJO.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class CustomerDao implements Dao<Customer> {
    @Override
    public void create(Customer customer) {
        try {
            String sql = "INSERT INTO customer (id, first_name, last_name, address, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Customer read(long id) {
        try {
            Customer customer = new Customer();
            String sql = "SELECT * FROM customer WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                customer.setId(result.getLong("id"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setAddress(result.getString("address"));
                customer.setPhone(result.getString("phone"));
                customer.setEmail(result.getString("email"));
                System.out.println("Record read.");
                System.out.println("id: " + customer.getId());
                System.out.println("first name: " + customer.getFirstName());
                System.out.println("last name: " + customer.getLastName());
                System.out.println("address: " + customer.getAddress());
                System.out.println("phone: " + customer.getPhone());
                System.out.println("email: " + customer.getEmail());
            }
            return customer;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Customer customer) {
        try {
            String sql = "UPDATE customer SET id = ?, first_name = ?, last_name = ?, address = ?, phone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, customer.getId());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setLong(7, id);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    @Override
    public void delete(long id) {
        try {
            String sql = "DELETE FROM customer WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
