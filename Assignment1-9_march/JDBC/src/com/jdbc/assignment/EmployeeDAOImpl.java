package com.jdbc.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void createTable() {
        String query = "CREATE TABLE IF NOT EXISTS employee (" +
                       "id INT PRIMARY KEY, " +
                       "name VARCHAR(50), " +
                       "salary DOUBLE PRECISION, " +
                       "department VARCHAR(50))";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate(query);
            System.out.println("Table created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertEmployee(Employee emp) {
        String query = "INSERT INTO employee (id, name, salary, department) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setDouble(3, emp.getSalary());
            ps.setString(4, emp.getDepartment());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee inserted successfully.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name, double salary, String department) {
        String query = "UPDATE employee SET name=?, salary=?, department=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, department);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee id not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee id not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchAllEmployees() {
        String query = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("---------------------------");
            }

            if (!found) {
                System.out.println("No records found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fetchEmployeeById(int id) {
        String query = "SELECT * FROM employee WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.println("Department: " + rs.getString("department"));
            } else {
                System.out.println("Employee id not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        String query = "DROP TABLE IF EXISTS employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement()) {

            st.executeUpdate(query);
            System.out.println("Table dropped successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}