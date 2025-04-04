package com.vbc.servlet.management.dao;

import com.vbc.servlet.management.db.DBConnection;
import com.vbc.servlet.management.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public boolean registerAdmin(Admin admin) {
        String sql = "INSERT INTO admin (admin_name, username, password) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, admin.getAdminName());
            stmt.setString(2, admin.getUsername());
            stmt.setString(3, admin.getPassword());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Admin loginadmin(String username, String password) {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setId(rs.getInt("id"));
                    admin.setAdminName(rs.getString("admin_name"));
                    admin.setUsername(rs.getString("username"));
                    admin.setPassword(rs.getString("password"));
                    return admin;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
