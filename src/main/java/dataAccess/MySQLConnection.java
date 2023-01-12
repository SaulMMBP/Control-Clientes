package dataAccess;

import java.sql.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Clase de conexión a base de datos
 * Para que funcione la conexión, se debe de agregar el conector de la base de datos al servidor
 * es decir, el archivo jar colocarlo en la carpeta lib del servidor (en este caso el conector de
 * MySQL en la carpeta de Tomcat 9.0) NO SE TE OLVIDE HDTRPM!!!!!!!
 * @author SAUL
 *
 */
public class MySQLConnection {

	/* Constantes de conexion */
	private static final String URL = "jdbc:mysql://localhost:3306/control_clientes_db?"
			+ "useSSL=false&"
			+ "useTimezone=true&"
			+ "serverTimezone=UTC&"
			+ "allowPublicKeyRetrieval=true";	
	private static final String USER = "root"; // Inseguro, solo con propósito de pruebas y aprendizaje
	private static final String PASSWORD = "dango1"; // Inseguro, solo con propósito de pruebas y aprendizaje
	
	/* Pool de Conexiones */
	private static BasicDataSource dataSource;
	
	/**
	 * Getter del pool de conexiones (DataSource)
	 * @return DataSource
	 */
	private static DataSource getDataSource() {
		if(dataSource == null) {
			/* Inicializamos el Pool de conexiones */
			dataSource = new BasicDataSource();
			
			/* Configuración de conexión */
			dataSource.setUrl(URL);
			dataSource.setUsername(USER);
			dataSource.setPassword(PASSWORD);
			
			/* Configuración de tamaño inicial */
			dataSource.setInitialSize(50);
		}
		return dataSource;
	}
	
	/**
	 * Getter de conexión a base de datos
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
	
	/**
	 * Cierra el proceso del objeto ResultSet
	 * @param resultSet
	 * @throws SQLException
	 */
	public static void close(ResultSet resultSet) throws SQLException {
		resultSet.close();
	}
	
	/**
	 * Cierra el proceso del objeto Statement
	 * @param statement
	 * @throws SQLException
	 */
	public static void close(Statement statement) throws SQLException {
		statement.close();
	}
	
	/**
	 * Cierra el proceso del objeto PreparedStatement
	 * @param preparedStatement
	 * @throws SQLException
	 */
	public static void close(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.close();
	}
	
	/**
	 * Cierra el proceso del objeto Connection
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		connection.close();
	}
	
}
