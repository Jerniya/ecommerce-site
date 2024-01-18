package cn.techtutorial.dao;

import java.sql.*;
import cn.techtutorial.model.*;

public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
	
	public boolean sigin(String email,String name,String pass) {
		 try {  
			 
		
	            query = "insert into users(name, email, password) values(?,?,?)";
	            pst = this.con.prepareStatement(query);
	            pst.setString(1,name);
	            pst.setString(2, email);
	            pst.setString(3, pass);
	            pst.executeUpdate();
	            if(rs==null) {
	            	return true;
	            }
	        } catch (SQLException e) {
	            System.out.print(e.getMessage());
	        }
	       return true;
	}
	public User adminLogin(String email, String password) {
		User user = null;
        try {
            query = "select * from admin where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}
