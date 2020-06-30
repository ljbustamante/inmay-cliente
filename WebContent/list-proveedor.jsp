<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-theme.min.css" rel="stylesheet">
<link href="css/bootstrapValidator.min.css" rel="stylesheet">

<link href="css/bootstrap-datepicker.css" rel="stylesheet">

<link href="css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrapValidator.min.css" rel="stylesheet">


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>


<script type="text/javascript" src="sweetalert/sweetalert.min.js"></script>




<title>Proveedor</title>
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
</style>
</head>
<body>
	<div class="container">
		<h3 align="center">Lista de Proveedores</h3>
		<button type="button" data-toggle='modal' class='btn btn-primary'
			id="validateBtnw2" onclick="mostrarVentana()">Nuevo
			Proveedor</button>
		<br>&nbsp;<br>
		<div id="divProveedor">
			<table id="id_table_proveedor"
				class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Empresa</th>
						<th>Cargo</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>

		</div>
	</div>

	<!-- INICIO DIV NUEVO -->
	<div class="modal fade" id="idModalRegistra">
		<div class="modal-dialog" style="width: 50%">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="padding: 5px 20px">

					<h4 id="idMensaje">Registro de Proveedor</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
					<form id="idRegistra" accept-charset="UTF-8" action=""
						class="form-horizontal" method="post" data-toggle="validator"
						role="form">
						<input type="hidden" id="ididProveedor" name="idProveedor">

						<div class="panel-group" id="steps">
							<!-- Step 1 -->
							<div class="panel panel-default">
								<div class="panel-heading"
									style="text-align: center; font-size: 14px"></div>
								<div class="panel-body">
									<div class="form-group">
										<label class="col-lg-3 control-label" for="id_reg_empresa">Empresa</label>
										<div class="col-lg-5">
											<input class="form-control" id="idEmpresa" name="empresa"
												placeholder="Ingrese Empresa" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label" for="id_reg_cargo">Cargo</label>
										<div class="col-lg-5">
											<input class="form-control" id="idCargo" name="cargo"
												placeholder="Ingrese Cargo" />
										</div>
									</div>
								</div>
								<div class="modal-footer"
									style="padding: 5px 20px; text-align: center">
									<button type="button" class="btn btn-primary" id="validatetBtn"
										onclick="grabarProveedor()">Registrar Proveedor</button>
									<button type="button" class="btn btn-danger" id="resetBtn">Cerrar</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- FIN DIV NUEVO -->

	<script type="text/javascript">
	function tablaProveedor(){
		$("#id_table_proveedor").DataTable().destroy();
		$("#id_table_proveedor tbody").empty(); 
		$.getJSON("listarProveedores",{}, function (response){
			$.each(response.listaProveedores, function(index, item){
			    var editar="<button type='button' class='btn btn-success' onclick='editarProveedor("+item.idProveedor+")'>Editar</button>";
			    var eliminar='<button type="button" class="btn btn-warning" onclick="eliminarProveedor('+item.idProveedor+')">Eliminar</button>';
			    
				$("#id_table_proveedor").append("<tr><td>"+item.idProveedor+"</td>"+
												  "<td>"+item.empresa+"</td>"+
												  "<td>"+item.cargo+"</td>"+
												  "<td>"+editar+"</td>"+
												  "<td>"+eliminar+"</td>");
			});
			$("#id_table_proveedor").DataTable().draw();
			$("#id_table_proveedor").DataTable();
		});
	}
	function eliminarProveedor(cod){
		swal({
			  title: "Seguro de eliminar Proveedor con id : "+cod,
			  text: "",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willSave) => {
			  if (willSave) {
				  $.ajax({
						url:  'eliminarProveedor',
						type: 'POST',
						data: {codigo:cod},
						success:function(data){
							if(data.dataMensaje==1){
								console.log(data);
								swal("Registro eliminado correctamente...","","success");
								tablaProveedor();
							}
							else
								swal("Error en la eliminación del registro...","","error");
						},
						error: function (jqXhr) { // error callback 
							swal("Error ...","","error");
				    	}
					})	
			  } 
			})
	}

	function editarProveedor(cod){
		$.getJSON("buscarProveedor",{codigo:cod}, function (response){
			$("#ididProveedor").val(response.proveedor.idProveedor);		
			$("#idEmpresa").val(response.proveedor.empresa);
			$("#idCargo").val(response.proveedor.cargo);
			$("#idMensaje").text("Actualizar Proveedor");
			$("#idModalRegistra").modal({show:true,keyboard:false,backdrop:'static'});
		})
		
	}
	
	function grabarProveedor(){
		
		var validator = $('#idRegistra').data('bootstrapValidator');
        validator.validate();
        if (validator.isValid()) {
			var json,cod,emp,car;
			cod=$("#ididProveedor").val();		
			emp=$("#idEmpresa").val();
			car=$("#idCargo").val();
			json=JSON.stringify({idProveedor:cod,empresa:emp,cargo:car});
			swal({
				  title: "Seguro de Guardar datos : ",
				  text: "",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willSave) => {
				  if (willSave) {
					  $.ajax({
							url:  'guardarProveedor',
							type: 'POST',
							data: {dataJSON:json,codigo:cod},
							success:function(data){
								if(data.dataMensaje==1){
									console.log(data);
									swal("Registro Guardado correctamente...","","success");
									tablaProveedor();
									$("#idModalRegistra").modal("hide");
									$('#idRegistra').data('bootstrapValidator').resetForm(true);
				   			    	$('#idRegistra').trigger("reset");
								}
								else
									swal("Error al guardar el registro...","","error");
							},
							error: function (jqXhr) { // error callback 
								swal("Error ...","","error");
					    	}
						})	
				  } 
				})
        }		
	}
	
	
	
	function mostrarVentana(){
		$('#idRegistra').data('bootstrapValidator').resetForm(true);
		$('#idRegistra').trigger("reset");
		$("#idCodigo").val(0);		
		$("#idMensaje").text("Registrar Proveedor");
		$("#validatetBtn").text("Registrar Proveedor");
		$("#idModalRegistra").modal({show:true,keyboard:false,backdrop:'static'});
	}

</script>
<script>	
	$(document).ready(function() {	
		tablaProveedor();
		 $('#resetBtn').click(function() {
		        $('#idRegistra').data('bootstrapValidator').resetForm(true);
		    	$('#idRegistra').trigger("reset");
		        $('#idModalRegistra').modal("hide");
		    });
	});
</script>
<script type="text/javascript">
$(document).ready(function() {
	//validar registra nuevo empleado
	$('#idRegistra').bootstrapValidator({
	    message: 'Este valor no es válido',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	empresa: {
	            validators: {
	                notEmpty: {
	                    message: 'El campo Empresa es requerido. No puede estar vacio'
	                },
	                stringLength: {
	                    min: 3,
	                    max: 30,
	                    message: 'El nombre de la empresa debe contener minimo 3 y maximo de 30 letras'
	                },
	                regexp: {
	                    regexp: /^[a-zA-Z\s\á\é\í\ó\ú\Á\É\Í\Ó\Ú\ñ\Ñ]+$/,
	                    message: 'El nombre sólo puede contener letras'
	                }
	            }
	        },
	        cargo:{
	        	validators:{
	        		notEmpty: {
	                    message: 'El campo Cargo es requerido. No puede estar vacio'
	                }
	        	}
	        }
	        
	        
	
	    }
	});
});
</script>


</body>
</html>












