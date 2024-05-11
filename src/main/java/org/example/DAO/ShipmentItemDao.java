package org.example.DAO;

import org.example.POJO.OrderItem;
import org.example.POJO.ShipmentItem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class ShipmentItemDao {
    public void create(ShipmentItem shipmentItem) {
        try {
            String sql = "INSERT INTO shipment_item (shipment_id, product_id, quantity) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipmentItem.getShipmentId());
            statement.setLong(2, shipmentItem.getProductId());
            statement.setInt(3, shipmentItem.getQuantity());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    public ShipmentItem read(long shipmentId, long productId) {
        try {
            ShipmentItem shipmentItem = new ShipmentItem();
            String sql = "SELECT * FROM shipment_item WHERE shipment_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipmentId);
            statement.setLong(2, productId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                shipmentItem.setShipmentId(result.getLong("shipment_id"));
                shipmentItem.setProductId(result.getLong("product_id"));
                shipmentItem.setQuantity(result.getInt("quantity"));

                System.out.println("Record read.");
                System.out.println("shipment id " + shipmentItem.getShipmentId());
                System.out.println("product id " + shipmentItem.getProductId());
                System.out.println("quantity: " + shipmentItem.getQuantity());

            }
            return shipmentItem;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    public void update(long shipmentId, long productId, ShipmentItem shipmentItem) {
        try {
            String sql = "UPDATE shipment_item SET shipment_id = ?, product_id = ?, quantity = ?" +
                    " WHERE shipment_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipmentItem.getShipmentId());
            statement.setLong(2, shipmentItem.getProductId());
            statement.setInt(3, shipmentItem.getQuantity());
            statement.setLong(4, shipmentId);
            statement.setLong(5, productId);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    public void delete(long shipmentId, long productId) {
        try {
            String sql = "DELETE FROM shipment_item WHERE shipment_id = ? AND product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipmentId);
            statement.setLong(2, productId);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }

}
