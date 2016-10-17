import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String args[]) throws ClassNotFoundException, SQLException{
		
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		
		//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //throws ClassNotFoundException
		
		//conn = DriverManager.getConnection("jdbc:odbc:Home"); //throws SQLException
		
		//java8 style for connecting msaccess
		
		conn = DriverManager.getConnection("jdbc:ucanaccess://E:\\New folder\\database\\Database1.accdb");
		
		ps = conn.prepareStatement("select * from LDAP_1 where username=?");
		ps.setString(1, "admin");
		rs = ps.executeQuery();
		
		while(rs.next()){
			String pwd = rs.getString("password");
			int id  = rs.getInt("id");
			System.out.println("password is "+pwd);
			System.out.println("id is "+id);
		}
		
	}
}
