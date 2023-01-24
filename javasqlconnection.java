import java.sql.Connection;
import java.sql.DriverManager;


public class DAO{
	private static final Connection Bookshop = null;

	String username = "root";

	String password = "isha2705";

	String DB_URL = "jdbc:mysql://localhost:3306/shop";

	public Connection getConnection() {
		Connection conn = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DB_URL, username, password);

			// STEP 3: Open a connection
			System.out.println("Connected to Database Successfully !!!");

		} catch (Exception e) {
			System.out.println("Unable to connect Database");
		}
		return conn;
	}
}