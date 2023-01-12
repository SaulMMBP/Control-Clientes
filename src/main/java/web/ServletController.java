package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dataAccess.*;
import entity.Cliente;

/**
 * Controlador de peticiones
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IClienteDAO clienteDAO = new ClienteDAOImpl();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		
		if (accion != null) {
			switch (accion) {
				case "editar":
					this.editarCliente(request, response);
					break;
				case "eliminar":
					this.eliminarCliente(request, response);
					break;
				default:
					this.accionDefault(request, response);
			} 
		} else {
			this.accionDefault(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		
		if (accion != null) {
			switch (accion) {
				case "insertar":
					this.insertarCliente(request, response);
					break;
				case "modificar":
					this.modificarCliente(request, response);
					break;
				default:
					this.accionDefault(request, response);
			} 
		} else {
			this.accionDefault(request, response);
		}
	}
	
	/**
	 * Obtiene una lista de usuario y los muestra en la página clientes.jsp
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/* Obtenemos la lista de clientes de la base de datos */
			List<Cliente> clientes = clienteDAO.selectAll();

			/* Almacenamos la lista de clientes en el Session scope y lo mandamos al jsp clientes.jsp*/
			HttpSession session = request.getSession();
			session.setAttribute("clientes", clientes);
			session.setAttribute("totalClientes", clientes.size());
			session.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
			response.sendRedirect("clientes.jsp");
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}
	
	/**
	 * Calcula el saldo total de la suma de los saldo de todos los clientes
	 * @param clientes
	 * @return
	 */
	private double calcularSaldoTotal(List<Cliente> clientes) {
		double saldoTotal = 0;
		for(Cliente cliente : clientes) {
			saldoTotal += cliente.getSaldo();
		}
		return saldoTotal;
	}

	/**
	 * Inserta un nuevo cliente en la base de datos
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String saldoString = request.getParameter("saldo");
		double saldo = (saldoString != null && !"".equals(saldoString)) ? Double.parseDouble(saldoString) : 0;
		
		
		Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
		
		try {
			clienteDAO.insert(cliente);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		this.accionDefault(request, response);
		
	}
	
	/**
	 * Manda a llamar a la página editar cliente y muestra los datos del cliente seleccionado en el 
	 * formulario
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		Cliente cliente = new Cliente(idCliente);
		
		try {
			clienteDAO.findById(cliente);
			request.setAttribute("cliente", cliente);
			String jspEditar = "/WEB-INF/view/cliente/editarCliente.jsp";
			request.getRequestDispatcher(jspEditar).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		
	}
	
	/**
	 * Modifica los datos del cliente con los datos proporcionados en el formulario
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String saldoString = request.getParameter("saldo");
		double saldo = (saldoString != null && !"".equals(saldoString)) ? Double.parseDouble(saldoString) : 0;
		
		
		Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
		
		try {
			clienteDAO.update(cliente);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		this.accionDefault(request, response);
		
	}
	
	/**
	 * Elimina un cliente con el id ingresado
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCliente = Integer.parseInt(request.getParameter("idCliente"));
		
		Cliente cliente = new Cliente(idCliente);
		
		try {
			clienteDAO.delete(cliente);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		this.accionDefault(request, response);
		
	}
}
