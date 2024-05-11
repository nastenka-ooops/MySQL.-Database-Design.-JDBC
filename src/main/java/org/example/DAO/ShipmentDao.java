package org.example.DAO;

import org.example.POJO.Order;
import org.example.POJO.Shipment;
import org.example.POJO.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.DatabaseConnection.connection;

public class ShipmentDao implements Dao<Shipment>{
    @Override
    public void create(Shipment shipment) {
        try {
            String sql = "INSERT INTO shipment (id, date, supplier_id, status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipment.getId());
            statement.setDate(2, shipment.getDate());
            statement.setLong(3, shipment.getSupplierId());
            statement.setInt(4, shipment.getStatus().ordinal());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Shipment read(long id) {
        try {
            Shipment shipment = new Shipment();
            String sql = "SELECT * FROM shipment WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                shipment.setId(result.getLong("id"));
                shipment.setDate(result.getDate("date"));
                shipment.setSupplierId(result.getInt("supplier_id"));
                shipment.setStatus(Status.values()[result.getInt("status")]);
                System.out.println("Record read.");
                System.out.println("id: " + shipment.getId());
                System.out.println("date: " + shipment.getDate());
                System.out.println("supplier id: " + shipment.getSupplierId());
                System.out.println("status: " + shipment.getStatus());
            }
            return shipment;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Shipment shipment) {
        try {
            String sql = "UPDATE shipment SET id = ?, date = ?, supplier_id = ?, status = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, shipment.getId());
            statement.setDate(2, shipment.getDate());
            statement.setLong(3, shipment.getSupplierId());
            statement.setInt(4, shipment.getStatus().ordinal());
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
            String sql = "DELETE FROM shipment WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
