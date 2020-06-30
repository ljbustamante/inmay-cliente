
function cboProvincia() {
	$("#Distrito").html("<option>Seleccionar</option>");
	$.post("cboProvincia.jsp", $("#data").serialize(), function(data) {
		$("#Provincia").html(data)
	});
}

function cboDistrito() {
	$.post("cboDistrito.jsp", $("#data").serialize(), function(data) {
		$("#Distrito").html(data)
	})
}