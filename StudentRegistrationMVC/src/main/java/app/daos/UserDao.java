package app.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.helpers.DBHelper;
import app.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public User loginUser(String email, String password){

        ResultSet resultSet;
        User user= null;
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT * FROM user WHERE email=? AND password=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public int createUser(User user) {
        int status = 0 ;
        Connection connection = DBHelper.getInstance().getConnection();
        System.out.println("Connection : "+ connection);
        String query="INSERT INTO user (name , email , password  , role_id) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getName());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setInt(4,user.getRole());
            status =  ps.executeUpdate();

            System.out.println("Status  : "+ status);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(("SQL EXCEPTION :"+ e));
        }
        System.out.println("Status  : "+ status);
        return status;
    }

    public int updateUser(User user) {
        // Get a connection to the database.
        Connection connection = DBHelper.getInstance().getConnection();
        System.out.println("Id  :  "+ user.getId());
        System.out.println("Name : "+ user.getName());
        System.out.println("Email : "+user.getEmail());
        System.out.println("Password  : "+ user.getPassword());
        System.out.println("Role :  "+ user.getRole());


        // Prepare a query to update user information.
        String query = "UPDATE user SET name=?, email=?, password=?, role_id=? WHERE id=?";

        try {
            // Create a prepared statement for safe SQL execution.
            PreparedStatement ps = connection.prepareStatement(query);

            // Set values for the placeholders in the SQL query.
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getRole());
            ps.setInt(5, user.getId());

            // Execute the update query and get the number of affected rows.
            int status = ps.executeUpdate();

            // Return the status to indicate the success or failure of the update.

            System.out.println("STATUS  ::::::  "+ status);
            return status;

        } catch (SQLException e) {
            // Print details of any issues encountered during the update.
            e.printStackTrace();
        }

        // If something went wrong, return 0 to signal an unsuccessful update.
        return 0;
    }


    public int userDelete(int user_id) {
        int status = 0 ;
        Connection connection = DBHelper.getInstance().getConnection();
        String query="DELETE FROM user WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,user_id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    public User getUserById(int user_id) {
        ResultSet resultSet ;
        User user = new User();
        Connection connection = DBHelper.getInstance().getConnection();
        String query="SELECT * FROM user WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1,user_id);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("USER GET ID BY DAO  : "+ user.getId());
        return user;
    }


    public List<User> getAllUsers() {
        ResultSet resultSet ;
        List<User> users = new ArrayList<>();
        Connection connection = DBHelper.getInstance().getConnection();
        String query="SELECT * FROM user";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public int getRoleIdByName(String name) {
        int roleId = 0; // Default value in case the role is not found
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT role_id FROM user WHERE name=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                roleId = resultSet.getInt("role_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("role Id "+ roleId);
        return roleId;
    }

    public String getUserNameByEmail(String email) {
        String userName = null;
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT name FROM user WHERE email=?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                userName = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userName;
    }
    public List<User> getUsersByName(String name) {
        List<User> users = new ArrayList<>();
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT * FROM user WHERE LOWER(TRIM(name)) LIKE LOWER(TRIM(?))";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            // Adding "%" before and after the search term for partial matching
            stmt.setString(1, "%" + name + "%");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getInt("role_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
        }
        return users;
    }

    public int getRoleByEmail(String email) {
        int roleId = 0; // Default value in case the role is not found
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT role_id FROM user WHERE email=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                roleId = resultSet.getInt("role_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Role Id by Email: " + roleId);
        return roleId;
    }
    public int getUserIdByEmail(String email) {
        int userId = 0; // Default value in case the user is not found
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT id FROM user WHERE email=?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                userId = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Exception: " + e.getMessage());
        }
        System.out.println("User Id by Email: " + userId);
        return userId;
    }




}
