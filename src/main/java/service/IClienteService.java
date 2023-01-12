package service;

import java.util.List;

import entity.Cliente;

public interface IClienteService {
	
	void createClient(Cliente cliente);

	List<Cliente> listClients();
		
	void updateClient(Cliente cliente);
	
	void deleteClient(Cliente cliente);

}
