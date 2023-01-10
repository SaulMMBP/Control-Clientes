package dataAccess;

import java.sql.*;
import java.util.*;

import entity.Cliente;

public class ClienteDAOImpl implements IClienteDAO {
	
	/* Consultas SQL */
	private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ?, ?)"; 
	private static final String SQL_SELECT = "SELECT * FROM cliente";
	private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
	private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
	
	/* Variables de Conexión, resultados y consultas */
	private Connection transactionalConnection;
	private Connection connection;
	private ResultSet result;
	private PreparedStatement statement;

	public ClienteDAOImpl() {
	}
	
	public ClienteDAOImpl(Connection transactionalConnection) {
		this.transactionalConnection = transactionalConnection;
	}

	@Override
	public int create(Cliente cliente) throws SQLException {
		int registries;
		
		/* Inicializamos la conexión 
		 * (si ya existe una conexión transaccional, es usa, si no se crea una conexión nueva */
		connection = (this.transactionalConnection != null) ? this.transactionalConnection : MySQLConnection.getConnection();
		
		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_INSERT);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellido());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefono());
		statement.setString(5, cliente.getSaldo());
		
		/* Ejecutamos la consulta (La consulta nos devuelve el número de registros en la tabla)*/
		registries = statement.executeUpdate();
		
		/* Cerramos los procesos de conexión y consultas 
		 * (La conexión se cierra solo si es nueva) */
		MySQLConnection.close(statement);
		if(this.transactionalConnection == null) MySQLConnection.close(connection);
		
		return registries;
	}

	@Override
	public List<Cliente> selectAll() throws SQLException {
		/* Inicializamos la conexión 
		 * (si ya existe una conexión transaccional, es usa, si no se crea una conexión nueva */
		connection = (this.transactionalConnection != null) ? this.transactionalConnection : MySQLConnection.getConnection();
		
		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_SELECT);
		
		/* Ejecutamos la consulta y guardamos el resultado */
		result = statement.executeQuery();
		
		/* Extraemos los resultados en objetos de tipo cliente */
		List<Cliente> clientes = new ArrayList<>();
		Cliente cliente = new Cliente();
		while(result.next()) {
			cliente.setIdCliente(result.getInt("id_cliente"));
			cliente.setNombre(result.getString("nombre"));
			cliente.setNombre(result.getString("apellido"));
			cliente.setNombre(result.getString("email"));
			cliente.setNombre(result.getString("telefono"));
			cliente.setNombre(result.getString("saldo"));
			
			clientes.add(cliente);
		}
		
		/* Cerramos los procesos de conexión y consultas 
		 * (La conexión se cierra solo si es nueva) */
		MySQLConnection.close(result);
		MySQLConnection.close(statement);
		if(this.transactionalConnection == null) MySQLConnection.close(connection);
		
		return clientes;
	}

	@Override
	public int update(Cliente cliente) throws SQLException {
		int registries;
		
		/* Inicializamos la conexión 
		 * (si ya existe una conexión transaccional, es usa, si no se crea una conexión nueva */
		connection = (this.transactionalConnection != null) ? this.transactionalConnection : MySQLConnection.getConnection();
		
		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_UPDATE);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellido());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefono());
		statement.setString(5, cliente.getSaldo());
		statement.setInt(6, cliente.getIdCliente());
		
		/* Ejecutamos la consulta (La consulta nos devuelve el número de registros en la tabla)*/
		registries = statement.executeUpdate();
		
		/* Cerramos los procesos de conexión y consultas 
		 * (La conexión se cierra solo si es nueva) */
		MySQLConnection.close(statement);
		if(this.transactionalConnection == null) MySQLConnection.close(connection);
		
		return registries;
	}

	@Override
	public int delete(Cliente cliente) throws SQLException {
		int registries;
		
		/* Inicializamos la conexión 
		 * (si ya existe una conexión transaccional, es usa, si no se crea una conexión nueva */
		connection = (this.transactionalConnection != null) ? this.transactionalConnection : MySQLConnection.getConnection();
		
		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_DELETE);
		statement.setInt(1, cliente.getIdCliente());
		
		/* Ejecutamos la consulta (La consulta nos devuelve el número de registros en la tabla)*/
		registries = statement.executeUpdate();

		/* Cerramos los procesos de conexión y consultas 
		 * (La conexión se cierra solo si es nueva) */
		MySQLConnection.close(statement);
		if(this.transactionalConnection == null) MySQLConnection.close(connection);
		
		return registries;
	}

}
