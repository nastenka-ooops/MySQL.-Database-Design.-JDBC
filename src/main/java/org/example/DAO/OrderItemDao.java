package org.example.DAO;

import org.example.POJO.Compatibility;
import org.example.POJO.OrderItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class OrderItemDao {
    public void create(OrderItem orderItem) {
        try {
            String sql = "INSERT INTO order_item (order_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, orderItem.getOrderId());
            statement.setLong(2, orderItem.getProductId());
            statement.setInt(3, orderItem.getQuantity());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    public OrderItem read(long orderId, long productId) {
        try {
            OrderItem orderItem = new OrderItem();
            String sql = "SELECT * FROM order_item WHERE order_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, orderId);
            statement.setLong(2, productId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                orderItem.setOrderId(result.getLong("order_id"));
                orderItem.setProductId(result.getLong("product_id"));
                orderItem.setQuantity(result.getInt("quantity"));

                System.out.println("Record read.");
                System.out.println("order id " + orderItem.getOrderId());
                System.out.println("product id " + orderItem.getProductId());
                System.out.println("quantity: " + orderItem.getQuantity());

            }
            return orderItem;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }
    public void update(long orderId, long productId, OrderItem orderItem) {
        try {
            String sql = "UPDATE order_item SET order_id = ?, product_id = ?, quantity = ?" +
                    " WHERE order_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, orderItem.getOrderId());
            statement.setLong(2, orderItem.getProductId());
            statement.setInt(3, orderItem.getQuantity());
            statement.setLong(4, orderId);
            statement.setLong(5, productId);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    public void delete(long orderId, long productId) {
        try {
            String sql = "DELETE FROM order_item WHERE order_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, orderId);
            statement.setLong(2, productId);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
