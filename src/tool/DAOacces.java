package tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOacces {

	private Connection connection;
	private String database = "ppe2";
	private String password = "";
	private String user = "root";

	public DAOacces() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/" + database
							+ "?useSSL=false&serverTimezone=UTC",
					user, password);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void close() {
		try {
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param connection
	 *            the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param database
	 *            the database to set
	 */
	public void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
}