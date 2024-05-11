package org.example.DAO;

import org.example.POJO.Customer;
import org.example.POJO.Employee;

import java.sql.*;
import java.time.LocalDate;

import static org.example.DatabaseConnection.connection;

public class EmployeeDao implements Dao<Employee>{
    @Override
    public void create(Employee employee) {
        try {
            String sql = "INSERT INTO employee (id, first_name, last_name, position, salary, hire_date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPosition());
            statement.setDouble(5, employee.getSalary().doubleValue());
            System.out.println(employee.getHireDate().toString());
            statement.setDate(6, employee.getHireDate());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            System.err.println("Record did not create");
        }
    }

    @Override
    public Employee read(long id) {
        try {
            Employee employee = new Employee();
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                employee.setId(result.getLong("id"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setPosition(result.getString("position"));
                employee.setSalary(result.getBigDecimal("salary"));
                employee.setHireDate(result.getDate("hire_date"));
                System.out.println("Record read.");
                System.out.println("id: " + employee.getId());
                System.out.println("first name: " + employee.getFirstName());
                System.out.println("last name: " + employee.getLastName());
                System.out.println("address: " + employee.getPosition());
                System.out.println("phone: " + employee.getSalary());
                System.out.println("email: " + employee.getHireDate());
            }
            return employee;
        } catch (SQLException e) {
            System.out.println("There is no such record");
            return null;
        }
    }

    @Override
    public void update(long id, Employee employee) {
        try {
            String sql = "UPDATE employee SET id = ?, first_name = ?, last_name = ?, position = ?, salary = ?, hire_date = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getPosition());
            statement.setBigDecimal(5, employee.getSalary());
            statement.setDate(6, employee.getHireDate());
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
            String sql = "DELETE FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            System.out.println("Record deleted.");
        } catch (SQLException e) {
            System.err.println("Record did not delete");
        }
    }
}
