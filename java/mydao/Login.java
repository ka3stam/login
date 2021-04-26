package mydao;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import db_connection.DBUtils;
import static db_connection.DBUtils.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User; 
/**
 *
 * @author matina
 */
public class Login {
    
    public User validateLogin(String username, String password){
        User user = null;
        ResultSet resultSet;
        PreparedStatement pst;
        HttpServletRequest request = null;
        try {

            Connection connection = getConnection();

            String sql = "select username,firstname,lastname,dob,AT,role,vote_before from users WHERE username = ? and password = ?;";
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
           
            resultSet = pst.executeQuery();
            if(resultSet.next()){
                user = new User( resultSet.getString(1), resultSet.getString(2),  resultSet.getString(3),  resultSet.getDate(4),  resultSet.getString(5),  resultSet.getByte(6),  resultSet.getByte(7)) ;
               
                System.out.println("Welcome back " + resultSet.getString(3) + " " + resultSet.getString(2));
                
            }
            else{
                System.out.println("Try again. Wrong credentials.");    
            }



        } catch (SQLException ex) {
            Logger.getLogger(DBUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
}
