package mainapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao 
{
	public boolean validate(LoginPojo pojo1) throws ClassNotFoundException, SQLException 
	{
		String email = pojo1.getEmail();
		String pass = pojo1.getPassword();
		
		ConnectionManager con = new ConnectionManager();
		Statement st = con.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * from UserData");
		con.getConnection().close();
		while(rs.next())
		{
			String tempEmail = rs.getString("EMAILID");
			String tempPass = rs.getString("PASSWORD");
			if(tempEmail.equals(email) && tempPass.equals(pass))
				return true;
		}
		return false;
}
}