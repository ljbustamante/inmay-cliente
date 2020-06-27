<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

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




<title>Docente</title>
<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 20px;
	}
	.btn-warning,.btn-info{
		width: 100px;
	}
	.btn-danger,.btn-primary{
		width: 160px;
	}
</style> 
</head>
<body>
	<div class="container">
		<h3 align="center">Lista Docentes</h3>
					<button type="button" data-toggle='modal'  
					class='btn btn-primary' 
					id="validateBtnw2" 
					onclick="mostrarVentana()">Nuevo Docente</button><br>&nbsp;<br>		
			<div id="divEmpleado">
		 								<table id="id_table_docente" class="table table-striped table-bordered" >
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Paterno</th>
															<th>Materno</th>
															<th>Sexo</th>
															<th>Hijos</th>
															<th>Sueldo</th>
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
 <div class="modal fade" id="idModalRegistra" >
			<div class="modal-dialog" style="width: 50%">
				<!-- Modal content-->
				<div class="modal-content">
				<div class="modal-header" style="padding: 5px 20px">
					
					<h4 id="idMensaje">Registro de Docente</h4>
				</div>
				<div class="modal-body" style="padding: 20px 10px;">
					<form id="idRegistra" accept-charset="UTF-8" action="" 
											class="form-horizontal" method="post" 
											data-toggle="validator" role="form">
							<input type="hidden" id="idCodigo" name="codigo">												
		                    
		                    <div class="panel-group" id="steps">
		                        <!-- Step 1 -->
		                        <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               
		                            </div>
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idNombre" name="nombre" placeholder="Ingrese el Nombre"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Paterno</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idPaterno" name="paterno" placeholder="Ingrese Paterno"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Materno</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idMaterno" name="materno" placeholder="Ingrese Materno"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Sexo</label>
		                                        <div class="col-lg-5">
													<select id="idSexo" name="sexo" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                                 <option value="Masculino">Masculino</option>
							                                 <option value="Femenino">Femenino</option>
							                         </select>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Hijos</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idHijos" name="numHijos" placeholder="Ingrese Hijos"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_sueldo">Sueldo</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idSueldo" name="sueldo" placeholder="Ingrese Sueldo"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_direccion">Dirección</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idDireccion" name="direccion" placeholder="Ingrese Direccion"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_distrito">Distrito</label>
		                                        <div class="col-lg-5">
													<select id="idDistrito" name="codigoDistrito" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                         </select>
		                                        </div>
		                                    </div>
		                                   
		                                    
		                                    
		                                </div>		                        
										<div class="modal-footer" style="padding: 5px 20px; text-align:center">
											<button type="button" class="btn btn-primary" id="validatetBtn" onclick="grabarDocente()">Registrar Docente</button>
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
	function tablaDocente(){
		$("#id_table_docente").DataTable().destroy();
		$("#id_table_docente tbody").empty(); 
		$.getJSON("listAllDocentes",{}, function (response){
			$.each(response.listaDocentes, function(index, item){
			    var editar="<button type='button' class='btn btn-success' onclick='editarDocente("+item.codigo+")'>Editar</button>";
			    var eliminar='<button type="button" class="btn btn-warning" onclick="eliminarDocente('+item.codigo+')">Eliminar</button>';
			    
				$("#id_table_docente").append("<tr><td>"+item.codigo+"</td>"+
												  "<td>"+item.nombre+"</td>"+
												  "<td>"+item.paterno+"</td>"+
												  "<td>"+item.materno+"</td>"+
												  "<td>"+item.sexo+"</td>"+
												  "<td>"+item.numHijos+"</td>"+
												  "<td>"+item.sueldo+"</td>"+
												  "<td>"+editar+"</td>"+
												  "<td>"+eliminar+"</td>");
			});
			$("#id_table_docente").DataTable().draw();
			$("#id_table_docente").DataTable();
		});
	}
	function eliminarDocente(cod){
		swal({
			  title: "Seguro de eliminar Docente con Código : "+cod,
			  text: "",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willSave) => {
			  if (willSave) {
				  $.ajax({
						url:  'eliminarDocente',
						type: 'POST',
						data: {codigo:cod},
						success:function(data){
							if(data.dataMensaje==1){
								console.log(data);
								swal("Registro eliminado correctamente...","","success");
								tablaDocente();
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

	function editarDocente(cod){
		$.getJSON("buscarDocente",{codigo:cod}, function (response){
			$("#idCodigo").val(response.docente.codigo);		
			$("#idNombre").val(response.docente.nombre);
			$("#idPaterno").val(response.docente.paterno);
			$("#idMaterno").val(response.docente.materno);
			$("#idSexo").val(response.docente.sexo);
			$("#idHijos").val(response.docente.numHijos);
			$("#idSueldo").val(response.docente.sueldo);
			$("#idDireccion").val(response.docente.direccion);
			$("#idDistrito").val(response.docente.codigoDistrito);
			$("#idMensaje").text("Actualizar Docente");
			$("#idModalRegistra").modal({show:true,keyboard:false,backdrop:'static'});
		})
		
	}
	
	function grabarDocente(){
		
		var validator = $('#idRegistra').data('bootstrapValidator');
        validator.validate();
        if (validator.isValid()) {
			var json,cod,nom,pat,mat,sex,hij,sue,dir,dis;
			cod=$("#idCodigo").val();		
			nom=$("#idNombre").val();
			pat=$("#idPaterno").val();
			mat=$("#idMaterno").val();
			sex=$("#idSexo").val();
			hij=$("#idHijos").val();
			sue=$("#idSueldo").val();
			dir=$("#idDireccion").val();
			dis=$("#idDistrito").val();
			json=JSON.stringify({codigo:cod,nombre:nom,paterno:pat,materno:mat,
								 sexo:sex,numHijos:hij,sueldo:sue,direccion:dir,codigoDistrito:dis});
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
							url:  'saveDocente',
							type: 'POST',
							data: {dataJSON:json,codigo:cod},
							success:function(data){
								if(data.dataMensaje==1){
									console.log(data);
									swal("Registro Guardado correctamente...","","success");
									tablaDocente();
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
		$("#idMensaje").text("Registrar Docente");
		$("#validatetBtn").text("Registrar Docente");
		$("#idModalRegistra").modal({show:true,keyboard:false,backdrop:'static'});
	}
	function mostrarDistritos(){
		$.getJSON("listAllDistritos",{},
		  function(data){
			$.each(data.listaDistritos,function(index,item){
			  $("#idDistrito").append("<option value='"+item.codigo+"'>"+
							item.nombre+"</option>");	
				})
		})
	}

</script>
<script>	
	$(document).ready(function() {
		mostrarDistritos();	
		tablaDocente();
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
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	nombre: {
	            validators: {
	                notEmpty: {
	                    message: 'El campo Nombre es requerido. No puede estar vacio'
	                },
	                stringLength: {
	                    min: 3,
	                    max: 30,
	                    message: 'El nombre debe contener minimo 3 y maximo de 30 letras'
	                },
	                regexp: {
	                    regexp: /^[a-zA-Z\s\á\é\í\ó\ú\Á\É\Í\Ó\Ú\ñ\Ñ]+$/,
	                    message: 'El nombre sólo puede contener letras'
	                }
	            }
	        },
	        paterno:{
	        	validators:{
	        		notEmpty: {
	                    message: 'El campo Paterno es requerido. No puede estar vacio'
	                }
	        	}
	        }
	        
	        
	
	    }
	});
});
</script>


</body>
</html>












