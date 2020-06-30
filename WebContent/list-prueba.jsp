<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-jquery-tags" prefix="sj"%>
<!-- IMPORTAMOS LIBRERIA BOTSRAP SIEMPRE-->
<%@ taglib uri="/struts-bootstrap-tags" prefix="sb"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <link href="css/bootstrap-theme.min.css" rel="stylesheet"> -->
<!-- <link href="css/bootstrapValidator.min.css" rel="stylesheet"> -->

<!-- <link href="css/bootstrap-datepicker.css" rel="stylesheet"> -->

<!-- <link href="css/dataTables.bootstrap.min.css" rel="stylesheet"> -->
<!-- <link href="css/bootstrapValidator.min.css" rel="stylesheet"> -->


<%-- <script type="text/javascript" src="js/jquery.min.js"></script> --%>
<%-- <script type="text/javascript" src="js/bootstrap.min.js"></script> --%>
<%-- <script type="text/javascript" src="js/bootstrapValidator.min.js"></script> --%>
<%-- <script type="text/javascript" src="js/jquery.dataTables.min.js"></script> --%>
<%-- <script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script> --%>

<%-- <script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script> --%>
<%-- <script type="text/javascript" src="sweetalert/sweetalert.min.js"></script> --%>

<jsp:include page="redund/head.html"/>
<script type="text/javascript" src="js/Localidades.js"></script>



<title>Productos</title>
<style>
.modal-header, h4, .close {
	background-color: #286090;
	color: white !important;
	text-align: center;
	font-size: 20px;
}

.btn-warning, .btn-info {
	width: 100px;
}

.btn-danger, .btn-primary {
	width: 160px;
	
}

.form-control{
	width: 200px;
	height: 30px !important;
	margin-bottom: 0px !important;
}

</style>
<sb:head />
</head>



<body class="hold-transition sidebar-mini layout-fixed">


	<div class="wrapper">

		<jsp:include page="redund/lateral_inicial.html" />

		<li class="nav-item has-treeview menu-open"><a href="./Index.jsp"
			class="nav-link"> <i class="nav-icon fas fa-tachometer-alt"></i>
				<p>Dashboard</p>
		</a></li>

		<li class="nav-item has-treeview"><a href="./Productos.jsp"
			class="nav-link active"> <i class="nav-icon fas fa-people-carry"></i>
				<p>Productos</p>
		</a></li>

		<li class="nav-item has-treeview"><a href="./Usuarios.jsp"
			class="nav-link"> <i class="nav-icon fas fa-user-cog"></i>
				<p>Usuarios</p>
		</a></li>


		<jsp:include page="redund/lateral_final.html" />



		<!-- Content Wrapper. Contains page content (CONTENIDO PRINCIPAL) -->
		<div class="content-wrapper">
			<div style="padding: 20px">
		
				<form action="prueba">
					<div class="container form-group">
						<h3 align="center">Lista Productos por Precio</h3>
						<input type="submit" class='btn btn-primary' value="Buscar Producto"/> 
							<input type="text" class='form-control' placeholder="Ingresa el primer precio" name="p1" /> 
							<input type="text" class='form-control' placeholder="Ingresa el segundo precio" name="p2" /> <br>&nbsp;<br>
						
						
						<div id="divProducto">
							<table id="id_table_producto"
								class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>ID</th>
										<th>DESCRIPCION</th>
										<th>CATEGORIA</th>
										<th>STOCK</th>
										<th>PRECIO</th>
										<th>PROVEEDOR</th>
									</tr>
								</thead>
								<tbody>
									<s:iterator value="listaProductos2">
										<tr class="grilla_campo">
											<td><s:property value="idProducto" /></td>
											<td><s:property value="descProducto" /></td>
											<td><s:property value="idCategoria" /></td>
											<td><s:property value="stock" /></td>
											<td><s:property value="precioU" /></td>
											<td><s:property value="idProveedor" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>

						</div>
					</div>
				</form>

			</div>
		</div>
		<!-- /.content-wrapper -->

		<script type="text/javascript">
			function ConfirmDemo(e) {
				if (confirm('¿Estas seguro de Eliminarlo?'))
					;
				else
					e.preventDefault();
			}
		</script>

		<!-- FooTer - (PARTE DE ABAJO) -->
		<jsp:include page="redund/footer.html" />

	</div>
	<!-- ./wrapper -->
	<jsp:include page="redund/scripts_final.html" />


</body>
</html>












