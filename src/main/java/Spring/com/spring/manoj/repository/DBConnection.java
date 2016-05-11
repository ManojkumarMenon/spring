package Spring.com.spring.manoj.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	DataSource ds = null;
	Connection con = null;
	public Connection getConnection(){
		
		try {
			Context init = new InitialContext();
			Context env = (Context)init.lookup("java:/comp/env");
			ds = (DataSource) env.lookup("jdbc/myoracle");
			con = ds.getConnection();
			return con;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return con;
	}
	
	public void closeConnection(){
		if(con != null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
