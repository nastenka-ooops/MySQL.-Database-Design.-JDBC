package org.example.DAO;

import org.example.POJO.Customer;
import org.example.POJO.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class SupplierDao implements Dao<Supplier>{
    @Override
    public void create(Supplier supplier) {
        try {
            String sql = "INSERT INTO supplier (id, company_name, address, phone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, supplier.getId());
            statement.setString(2, supplier.getCompanyName());
            statement.setString(3, supplier.getAddress());
            statement.setString(4, supplier.getPhone());
            statement.setString(5, supplier.getEmail());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Supplier read(long id) {
        try {
            Supplier supplier = new Supplier();
            String sql = "SELECT * FROM supplier WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                supplier.setId(result.getLong("id"));
                supplier.setCompanyName(result.getString("company_name"));
                supplier.setAddress(result.getString("address"));
                supplier.setPhone(result.getString("phone"));
                supplier.setEmail(result.getString("email"));
                System.out.println("Record read.");
                System.out.println("id: " + supplier.getId());
                System.out.println("company name: " + supplier.getCompanyName());
                System.out.println("address: " + supplier.getAddress());
                System.out.println("phone: " + supplier.getPhone());
                System.out.println("email: " + supplier.getEmail());
            }
            return supplier;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Supplier supplier) {
        try {
            String sql = "UPDATE supplier SET id = ?, company_name = ?, address = ?, phone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, supplier.getId());
            statement.setString(2, supplier.getCompanyName());
            statement.setString(3, supplier.getAddress());
            statement.setString(4, supplier.getPhone());
            statement.setString(5, supplier.getEmail());
            statement.setLong(6, id);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    @Override
    public void delete(long id) {
        try {
            String sql = "DELETE FROM supplier WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
