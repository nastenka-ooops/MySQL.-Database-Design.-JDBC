package org.example.DAO;

import org.example.POJO.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.DatabaseConnection.connection;

public class ProductDao implements Dao<Product> {
    @Override
    public void create(Product product) {
        try {
            String sql = "INSERT INTO product (id, name, height, price) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getHeight());
            statement.setDouble(4, product.getPrice().doubleValue());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Product read(long id) {
        try {
            Product product = new Product();
            String sql = "SELECT * FROM product WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                product.setId(result.getLong("id"));
                product.setName(result.getString("name"));
                product.setHeight(result.getInt("height"));
                product.setPrice(result.getBigDecimal("price"));
                System.out.println("Record read.");
                System.out.println("id: " + product.getId());
                System.out.println("name: " + product.getName());
                System.out.println("height: " + product.getHeight());
                System.out.println("price: " + product.getPrice());
            }
            return product;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Product product) {
        try {
            String sql = "UPDATE product SET id = ?, name = ?, height = ?, price = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, product.getId());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getHeight());
            statement.setBigDecimal(4, product.getPrice());
            statement.setLong(5, id);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    @Override
    public void delete(long id) {
        try {
            String sql = "DELETE FROM product WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
