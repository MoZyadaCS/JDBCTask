import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceClass implements UserService {

    @Override
    public User addUser(User user) {
        try{
            Connection connection = DbConnection.getConnection();
            String query = "insert into user (username,password,phone,birthdate) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setDate(4, user.getBirthDate());
            preparedStatement.executeUpdate();
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(String id, User user) {
        try{
            Connection connection = DbConnection.getConnection();
            String query = "update user set username = ?, password = ?, phone = ?, birth = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setDate(4, user.getBirthDate());
            preparedStatement.setInt(5, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        try{
            Connection connection = DbConnection.getConnection();
            String query = "delete from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUser(String id) {
        try(Connection connection = DbConnection.getConnection()){
            String query = "select * from user where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet result = preparedStatement.executeQuery();
            User user = new User();
            while(result.next()){
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setBirthDate(result.getDate("birth"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        try(Connection connection = DbConnection.getConnection()){
            String query = "select * from user";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                User user = new User();
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setBirthDate(result.getDate("birth"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<User> getUserByPhone(String phone) {
        try{
            Connection connection = DbConnection.getConnection();
            String query = "select * from user where phone = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phone);
            ResultSet result = preparedStatement.executeQuery();
            User user = new User();
            while(result.next()){
                user.setId(result.getInt("id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setPhone(result.getString("phone"));
                user.setBirthDate(result.getDate("birth"));
            }
            return Optional.of(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
