package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtill {
	
	
	private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static boolean insertUser(String name, String email, String phone, String username, String password) {
        boolean isSuccess = false;

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "INSERT INTO sample (name, email, phone, username,password) VALUES ('" + name + "', '" + email + "', '" + phone + "', '" + username + "','"+password+"')";
            int rs = stmt.executeUpdate(sql);

            isSuccess = rs > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccess;
    }
    
    public static List<user> getAllUsers() {
        List<user> users = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            stmt = con.createStatement();
            String sql = "SELECT * FROM sample";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
            	
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                users.add(new user(id, name,email,phone,username,password));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
    
    public static user selectUser(int id) {
        user user = null;

        try {
            con = DBConnect.getConnection();
            String sql = "SELECT * FROM sample WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                user = new user(id,name,email,phone,username,password);
            }
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        } finally {
        	
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public static boolean updateUser(user user) {
        boolean rowUpdated = false;
        try {
            con = DBConnect.getConnection();
            String sql = "UPDATE sample SET name = ?, email = ?, phone = ?, username = ? , password = ? WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setString(4, user.getUsername());
            preparedStatement.setString(5, user.getPassword());
            
            preparedStatement.setInt(6, user.getId());
            
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowUpdated;
    }
    
    public static boolean DeleteUser(int id) {
    	
        boolean rowDeleted = false;
        try {
            con = DBConnect.getConnection();
            String sql = "DELETE FROM sample WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;
    }

	

	

}
