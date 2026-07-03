package assignment.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import assignment.cart.Cart;


public class UsersManager {

    public static final String BASIC_USER_ID = "User00-";
    protected static final List<User> users = new ArrayList<>();


    public boolean findUserFromDB(String userID) throws SQLException {
        String query = "select firstname, lastname " + "from USERS where username="+ (BASIC_USER_ID+userID);
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", BASIC_USER_ID+userID, System.getenv("DB_PASSWORD"));
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();) {
            return (rs.next());

        } catch (SQLException e) {
            return false;
        }
    }

    public void addUser(User user) throws SQLException{
        if(!findUserFromDB(user.getUserID()))
            users.add(user);
    }
    
    public void removeEmptyTitlesFromUser(User user) {      
        List<String> titles = user.getTitles();
        for (int i = titles.size()-1; i >= 0; i--) {
          if (titles.get(i).isEmpty()) {
            titles.remove(i);
          }
        }
    }

    public void addCartToUser(User user, Cart cart) throws NullPointerException{
        user.linkCart(cart);
    }
}
