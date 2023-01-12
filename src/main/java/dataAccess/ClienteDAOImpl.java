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
	private static final String SQL_FINDBYID = "SELECT * FROM cliente WHERE id_cliente=?";

	@Override
	public int insert(Cliente cliente) throws SQLException {
		int registries = 0;
		Connection connection = null;
		PreparedStatement statement = null;

		/*
		 * Inicializamos la conexión (si ya existe una conexión transaccional, es usa,
		 * si no se crea una conexión nueva
		 */
		connection = MySQLConnection.getConnection();

		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_INSERT);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellido());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefono());
		statement.setDouble(5, cliente.getSaldo());

		/*
		 * Ejecutamos la consulta (La consulta nos devuelve el número de registros en la
		 * tabla)
		 */
		registries = statement.executeUpdate();

		/*
		 * Cerramos los procesos de conexión y consultas (La conexión se cierra solo si
		 * es nueva)
		 */
		MySQLConnection.close(statement);
		MySQLConnection.close(connection);

		return registries;
	}

	@Override
	public List<Cliente> selectAll() throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		/* Extraemos los resultados en objetos de tipo cliente */
		List<Cliente> clientes = new ArrayList<>();

		/*
		 * Inicializamos la conexión (si ya existe una conexión transaccional, es usa,
		 * si no se crea una conexión nueva
		 */
		connection = MySQLConnection.getConnection();

		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_SELECT);

		/* Ejecutamos la consulta y guardamos el resultado */
		result = statement.executeQuery();

		while (result.next()) {
			int idCliente = result.getInt("id_cliente");
			String nombre = result.getString("nombre");
			String apellido = result.getString("apellido");
			String email = result.getString("email");
			String telefono = result.getString("telefono");
			double saldo = result.getDouble("saldo");

			Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
			clientes.add(cliente);
		}

		/*
		 * Cerramos los procesos de conexión y consultas (La conexión se cierra solo si
		 * es nueva)
		 */
		MySQLConnection.close(result);
		MySQLConnection.close(statement);
		MySQLConnection.close(connection);
		return clientes;
	}

	@Override
	public int update(Cliente cliente) throws SQLException {
		int registries = 0;
		Connection connection = null;
		PreparedStatement statement = null;

		/*
		 * Inicializamos la conexión (si ya existe una conexión transaccional, es usa,
		 * si no se crea una conexión nueva
		 */
		connection = MySQLConnection.getConnection();

		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_UPDATE);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellido());
		statement.setString(3, cliente.getEmail());
		statement.setString(4, cliente.getTelefono());
		statement.setDouble(5, cliente.getSaldo());
		statement.setInt(6, cliente.getIdCliente());

		/*
		 * Ejecutamos la consulta (La consulta nos devuelve el número de registros en la
		 * tabla)
		 */
		registries = statement.executeUpdate();

		/*
		 * Cerramos los procesos de conexión y consultas (La conexión se cierra solo si
		 * es nueva)
		 */
		MySQLConnection.close(statement);
		MySQLConnection.close(connection);
		return registries;
	}

	@Override
	public int delete(Cliente cliente) throws SQLException {
		int registries = 0;
		Connection connection = null;
		PreparedStatement statement = null;

		/*
		 * Inicializamos la conexión (si ya existe una conexión transaccional, es usa,
		 * si no se crea una conexión nueva
		 */
		connection = MySQLConnection.getConnection();

		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_DELETE);
		statement.setInt(1, cliente.getIdCliente());

		/*
		 * Ejecutamos la consulta (La consulta nos devuelve el número de registros en la
		 * tabla)
		 */
		registries = statement.executeUpdate();

		/*
		 * Cerramos los procesos de conexión y consultas (La conexión se cierra solo si
		 * es nueva)
		 */
		MySQLConnection.close(statement);
		MySQLConnection.close(connection);
		return registries;
	}

	@Override
	public void findById(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;

		/*
		 * Inicializamos la conexión (si ya existe una conexión transaccional, es usa,
		 * si no se crea una conexión nueva
		 */
		connection = MySQLConnection.getConnection();

		/* Configuramos la consulta */
		statement = connection.prepareStatement(SQL_FINDBYID);
		statement.setInt(1, cliente.getIdCliente());

		/* Ejecutamos la consulta y guardamos el resultado */
		result = statement.executeQuery();

		if (result.next()) {
			String nombre = result.getString("nombre");
			String apellido = result.getString("apellido");
			String email = result.getString("email");
			String telefono = result.getString("telefono");
			double saldo = result.getDouble("saldo");
			
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setSaldo(saldo);
		}
		
		/*
		 * Cerramos los procesos de conexión y consultas (La conexión se cierra solo si
		 * es nueva)
		 */
		MySQLConnection.close(result);
		MySQLConnection.close(statement);
		MySQLConnection.close(connection);
	}

}
