<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		<link rel="stylesheet" href="resources/css/normalize.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />

		<title>Editar Cliente</title>
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="/WEB-INF/view/commons/header.jsp" />

		<main>
			<section class="editSection">
				<!-- Botones -->
				<jsp:include page="/WEB-INF/view/cliente/navegacionEdicion.jsp" />

				<!-- form -->
				<h2 class="form-header">Editar Cliente</h2>
				<form id="editForm"
					action="${ pageContext.request.contextPath }/ServletController?accion=modificar&idCliente=${ cliente.idCliente }"
					method="post">
					<div class="form-control">
						<label for="nombre">Nombre*</label>
						<input name="nombre" type="text" required value="${ cliente.nombre }" />
					</div>

					<div class="form-control">
						<label for="apellido">Apellido*</label>
						<input name="apellido" type="text" required value="${ cliente.apellido }" />
					</div>

					<div class="form-control">
						<label for="email">Email*</label>
						<input name="email" type="email" required value="${ cliente.email }" />
					</div>

					<div class="form-control">
						<label for="telefono">Telefono*</label>
						<input name="telefono" type="tel" required value="${ cliente.telefono }" />
					</div>

					<div class="form-control">
						<label for="saldo">Saldo*</label>
						<input name="saldo" type="number" required value="${ cliente.saldo }" step="any" />
					</div>
				</form>
			</section>
		</main>

		<!-- footer -->
		<jsp:include page="/WEB-INF/view/commons/footer.jsp" />
	</body>
</html>