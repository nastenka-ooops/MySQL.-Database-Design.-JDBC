package org.example.DAO;

import org.example.POJO.Inventory;
import org.example.POJO.Order;
import org.example.POJO.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class OrderDao implements Dao<Order> {
    @Override
    public void create(Order order) {
        try {
            String sql = "INSERT INTO flower_shop.order (id, date, customer_id, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, order.getId());
            statement.setDate(2, order.getDate());
            statement.setLong(3, order.getCustomerId());
            statement.setInt(4, order.getStatus().ordinal());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Order read(long id) {
        try {
            Order order = new Order();
            String sql = "SELECT * FROM flower_shop.order WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                order.setId(result.getLong("id"));
                order.setDate(result.getDate("date"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setStatus(Status.values()[result.getInt("status")]);
                System.out.println("Record read.");
                System.out.println("id: " + order.getId());
                System.out.println("date: " + order.getDate());
                System.out.println("customer id: " + order.getCustomerId());
                System.out.println("status: " + order.getStatus());
            }
            return order;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Order order) {
        try {
            String sql = "UPDATE flower_shop.order SET id = ?, date = ?, customer_id = ?, status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, order.getId());
            statement.setDate(2, order.getDate());
            statement.setLong(3, order.getCustomerId());
            statement.setInt(4, order.getStatus().ordinal());
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
            String sql = "DELETE FROM flower_shop.order WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
