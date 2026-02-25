/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistence;

/**
 *
 * @author emirersan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeaLogRepository {
    private static final String URL =
            "jdbc:mysql://localhost:3306/se3317?serverTimezone=Europe/Istanbul";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertCups(int cups) {
        String sql = "INSERT INTO tea_history (cups) VALUES (?)";
        

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cups);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
     public int getMonthlyTotal() {
        String sql =
                "SELECT COALESCE(SUM(cups), 0) " +
                "FROM tea_history " +
                "WHERE MONTH(served_at) = MONTH(CURDATE()) " +
                "AND YEAR(served_at) = YEAR(CURDATE())";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }

    public int getTodayTotal() {
        String sql =
                "SELECT COALESCE(SUM(cups), 0) " +
                "FROM tea_history " +
                "WHERE DATE(served_at) = CURDATE()";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return 0;
    }
}
