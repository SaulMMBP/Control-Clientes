<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="resources/css/normalize.css" />
		<link rel="stylesheet" href="resources/css/style.css" />
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
		<title>Control de Clientes</title>
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="WEB-INF/view/commons/header.jsp" />
		<main>
			<!-- Totales -->
			<jsp:include page="/WEB-INF/view/cliente/totalData.jsp" />
			<!-- Listado de clientes -->
			<jsp:include page="/WEB-INF/view/cliente/listadoClientes.jsp" />
		</main>
		<!-- footer -->
		<jsp:include page="WEB-INF/view/commons/footer.jsp" />
	</body>
	<script type="text/javascript" src="resources/js/script.js"></script>
</html>