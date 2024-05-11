package org.example.DAO;

import org.example.POJO.Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class InventoryDao implements Dao<Inventory> {
    @Override
    public void create(Inventory inventory) {
        try {
            String sql = "INSERT INTO inventory (product_id, quantity, shipment_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, inventory.getProductId());
            statement.setInt(2, inventory.getQuantity());
            statement.setDate(3, inventory.getShipmentDate());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Inventory read(long productId) {
        try {
            Inventory inventory = new Inventory();
            String sql = "SELECT * FROM inventory WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, productId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                inventory.setProductId(result.getLong("product_id"));
                inventory.setQuantity(result.getInt("quantity"));
                inventory.setShipmentDate(result.getDate("shipment_date"));
                System.out.println("Record read.");
                System.out.println("product_id: " + inventory.getProductId());
                System.out.println("quantity: " + inventory.getQuantity());
                System.out.println("shipment date: " + inventory.getShipmentDate());
            }
            return inventory;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long productId, Inventory inventory) {
        try {
            String sql = "UPDATE inventory SET product_id = ?, quantity = ?, shipment_date = ? WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, inventory.getProductId());
            statement.setInt(2, inventory.getQuantity());
            statement.setDate(3, inventory.getShipmentDate());
            statement.setLong(4, productId);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    @Override
    public void delete(long productId) {
        try {
            String sql = "DELETE FROM inventory WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, productId);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
