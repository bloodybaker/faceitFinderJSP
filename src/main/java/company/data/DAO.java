package company.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

    private static DAO instance;
    public boolean connected;
    public boolean isConnected(){
        return connected;
    }

    public DAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Config.HOST, Config.USER, Config.PASS);
            connected = true;

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private Connection connection = null;
    public boolean login(String login, String pass, String tablename){
        try {
            PreparedStatement select = connection.prepareStatement("SELECT password FROM " + tablename + " WHERE username = ?");
            select.setString(1,login);
            ResultSet resultSet = select.executeQuery();
            String temp = "";
            while (resultSet.next()){
                temp = resultSet.getString(1);
            }
            if(temp.equals(pass)){
                return true;
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    public String getFirstName(String username, String tablename){
        String temp = "";
        try {
            PreparedStatement select = connection.prepareStatement("SELECT first_name FROM " + tablename + " WHERE username = ?");
            select.setString(1,username);
            ResultSet resultSet = select.executeQuery();
            while (resultSet.next()){
                temp = resultSet.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }
    public String getLastName(String username, String tablename){
        String temp = "";
        try {
            PreparedStatement select = connection.prepareStatement("SELECT last_name FROM " + tablename + " WHERE username = ?");
            select.setString(1,username);
            ResultSet resultSet = select.executeQuery();
            while (resultSet.next()){
                temp = resultSet.getString(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return temp;
    }
    public static DAO getInstance(){
        if(instance == null){
            instance = new DAO();
        }
        return instance;
    }
}
