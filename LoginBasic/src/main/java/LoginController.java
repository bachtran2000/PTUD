
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author bachtrancaominh
 */
public class LoginController {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "";

    public LoginController() {
    }

    public static Connection DBConnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER_NAME, DATABASE_PASSWORD);
            System.out.println("Connect Success!");
            return con;
        } catch (Exception e) {
            System.out.println("Fail!" + e);
        }
        return null;
    }

    public boolean checkLogin(String username, String password) throws ClassNotFoundException, SQLException {

        Connection conn = DBConnect();
        java.sql.Statement stm = conn.createStatement();
        String sql = "Select * from nhanvien where username='" + username + "' and password='" + password + "'";
        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            System.out.println("Successfull !!!");
            return true;
        } else {
            System.out.println("Fail!");
        }
        return false;

    }

    public static void main(String[] args) {
        LoginForm lg = new LoginForm();
        lg.show();

    }

}
