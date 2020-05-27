package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao 
{
	public void addUser(RegisterPojo pojo) throws ClassNotFoundException, SQLException{
		String firstname = pojo.getFirstname();
		String lastname = pojo.getLastname();
		String username = pojo.getUsername();
		String password = pojo.getPassowrd();
		String email = pojo.getEmail();
		
		ConnectionManager cm = new ConnectionManager();
		System.out.println("");
		//insert all the details into database
		String sql = "INSERT into UserDetails(firstname, lastname, username, password, email) VALUES (?,?,?,?,?)";
		//create statement object
		PreparedStatement st = cm.getConnection().prepareStatement(sql);
		System.out.println("Statement Prepared");
		st.setString(1, firstname);
		st.setString(2, lastname);
		st.setString(3, username);
		st.setString(4, password);
		st.setString(5, email);
		
		st.executeUpdate();
		//System.out.println("Data Inserted");
		cm.getConnection().close();
	}
}