package org.example.DAO;

import org.example.POJO.Compatibility;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.DatabaseConnection.connection;

public class CompatibilityDao{

    public void create(Compatibility compatibility) {
        try {
            String sql = "INSERT INTO compatibility (dominant_flower_id, compatible_flower_id, optimal_quantity) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, compatibility.getDominantFlowerId());
            statement.setLong(2, compatibility.getCompatibleFlowerId());
            statement.setDouble(3, compatibility.getOptimalQuantity());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    public Compatibility read(long dominantFlowerId, long compatibleFlowerId) {
        try {
            Compatibility compatibility = new Compatibility();
            String sql = "SELECT * FROM compatibility WHERE dominant_flower_id = ?, compatible_flower_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, dominantFlowerId);
            statement.setLong(2, compatibleFlowerId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                compatibility.setDominantFlowerId(result.getLong("dominant_flower_id"));
                compatibility.setCompatibleFlowerId(result.getLong("compatible_flower_id"));
                compatibility.setOptimalQuantity(result.getDouble("optimal_quantity"));

                System.out.println("Record read.");
                System.out.println("dominant_flower_id " + compatibility.getDominantFlowerId());
                System.out.println("compatible_flower_id " + compatibility.getCompatibleFlowerId());
                System.out.println("optimal_quantity: " + compatibility.getOptimalQuantity());

            }
            return compatibility;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }
    public void update(long dominantFlowerId, long compatibleFlowerId, Compatibility compatibility) {
        try {
            String sql = "UPDATE compatibility SET dominant_flower_id = ?, compatible_flower_id = ?, optimal_quantity = ?" +
                    " WHERE dominant_flower_id = ? AND compatible_flower_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, compatibility.getDominantFlowerId());
            statement.setLong(2, compatibility.getCompatibleFlowerId());
            statement.setDouble(3, compatibility.getOptimalQuantity());
            statement.setLong(4, dominantFlowerId);
            statement.setLong(5, compatibleFlowerId);
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            System.err.println("Record did not update");
        }
    }

    public void delete(long dominantFlowerId, long compatibleFlowerId) {
        try {
            String sql = "DELETE FROM compatibility WHERE dominant_flower_id = ? AND compatible_flower_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, dominantFlowerId);
            statement.setLong(2, compatibleFlowerId);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }

}
