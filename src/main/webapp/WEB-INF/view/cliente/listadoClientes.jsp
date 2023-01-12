<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />
<section class="data">
	<jsp:include page="/WEB-INF/view/cliente/navegacion.jsp" />
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Saldo</th>
				<th>Editar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cliente" items="${ clientes }">
				<tr>
					<td data-label="ID">${ cliente.idCliente }</td>
					<td data-label="Nombre">${ cliente.nombre } ${ cliente.apellido }</td>
					<td data-label="Saldo">
						<fmt:formatNumber value="${ cliente.saldo }" type="currency" />
					</td>
					<td data-label="Editar">
						<a href="${ pageContext.request.contextPath }/ServletController?accion=editar&idCliente=${ cliente.idCliente }"
							class="btn btn-small"> <i class="bi bi-pencil-square"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

<!-- Agregar modal -->
<jsp:include page="/WEB-INF/view/cliente/agregarCliente.jsp" />