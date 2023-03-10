package dataAccess;

import java.sql.SQLException;
import java.util.List;

import entity.Cliente;

public interface IClienteDAO {

	int insert(Cliente cliente) throws SQLException;

	List<Cliente> selectAll() throws SQLException;
		
	int update(Cliente cliente) throws SQLException;
	
	int delete(Cliente cliente) throws SQLException;
	
	void findById(Cliente cliente) throws SQLException;
}
