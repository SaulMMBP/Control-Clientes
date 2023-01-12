package service;

import java.sql.*;
import java.util.*;

import dataAccess.*;
import entity.Cliente;

/**
 * 
 * @author SAUL
 *
 */
public class ClienteServiceImpl implements IClienteService {

	@Override
	public void createClient(Cliente cliente) {
		Connection connection = null;

		try {
			/* Creamos conexion */
			connection = MySQLConnection.getConnection();
			
			/* Configuramos el autocommit a false */
			if(connection.getAutoCommit()) connection.setAutoCommit(false);
			
			/* Pasamos la conexión a la implementación del DAO cliente */
			IClienteDAO clienteDAO = new ClienteDAOImpl(connection);
			
			/* Insertamos el cliente creado en la base de datos */
			clienteDAO.insert(cliente);
			
			/* Confirmamos la transacción */
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			try {
				connection.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace(System.out);
			}
		}
	}

	@Override
	public List<Cliente> listClients() {
		Connection connection = null;
		List<Cliente> clientes = new ArrayList<>();

		try {
			/* Creamos conexion */
			connection = MySQLConnection.getConnection();
			
			/* Configuramos el autocommit a false */
			if(connection.getAutoCommit()) connection.setAutoCommit(false);
			
			/* Pasamos la conexión a la implementación del DAO cliente */
			IClienteDAO clienteDAO = new ClienteDAOImpl(connection);
			
			/* Obtenemos la lista de clientes */
			clientes = clienteDAO.selectAll();
			
			/* Confirmamos la transacción */
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			try {
				connection.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace(System.out);
			}
		}
		return clientes;
	}

	@Override
	public void updateClient(Cliente cliente) {
		Connection connection = null;

		try {
			/* Creamos conexion */
			connection = MySQLConnection.getConnection();
			
			/* Configuramos el autocommit a false */
			if(connection.getAutoCommit()) connection.setAutoCommit(false);
			
			/* Pasamos la conexión a la implementación del DAO cliente */
			IClienteDAO clienteDAO = new ClienteDAOImpl(connection);
			
			/* Actualizamos el cliente */
			clienteDAO.update(cliente);
			
			/* Confirmamos la transacción */
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			try {
				connection.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace(System.out);
			}
		}
	}

	@Override
	public void deleteClient(Cliente cliente) {
		Connection connection = null;

		try {
			/* Creamos conexion */
			connection = MySQLConnection.getConnection();
			
			/* Configuramos el autocommit a false */
			if(connection.getAutoCommit()) connection.setAutoCommit(false);
			
			/* Pasamos la conexión a la implementación del DAO cliente */
			IClienteDAO clienteDAO = new ClienteDAOImpl(connection);
			
			/* Eliminamos el cliente */
			clienteDAO.delete(cliente);
			
			/* Confirmamos la transacción */
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			try {
				connection.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace(System.out);
			}
		}
	}

}
