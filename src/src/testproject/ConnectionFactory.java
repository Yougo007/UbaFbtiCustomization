package src.testproject;
import java.sql.*;



/**
 * 
 * @author Ugochukwu Udokporo
 * Modified 04-01-2018
 *
 */

public class ConnectionFactory {
	
	public ConnectionFactory() {		
	}
    // JDBC driver name and database URL
    //static final String mysql_JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    //static final String sql_JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    static final String USER = "TIZONE1";
    static final String PASS = "TIZONE1";
    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;
    String sqlString;
   
    
    public Connection getDatabaseConnection() throws SQLException {
        try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        return conn;
      }
}
