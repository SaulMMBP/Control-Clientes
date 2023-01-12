<div class="actions">
	<a class="btn-link" href="index.jsp"><i class="bi bi-arrow-left-short"></i> Regresar al inicio</a>
	<button class="btn btn-small" form="editForm" type="submit"><i class="bi bi-pencil"></i> Guardar Cambios</button>
	<a class="btn btn-small" href="${ pageContext.request.contextPath }/ServletController?accion=eliminar&idCliente=${ cliente.idCliente}"><i class="bi bi-trash"></i> Eliminar Cliente</a>
</div>