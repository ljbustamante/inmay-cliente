package com.cibertec.entidad;
import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable{
	private int idUsuario;
	private String nombreU;
	private String apellidoU;
	private String emailU;
	private String claveU;
	private Date fRegistroU;
	private String direccionU;
	private int idPais;
	private int idCiudad;
	private int idProvincia;
	private int idDistrito;
	private String telefonoU;
	private int idEstadoUsuario;
	private boolean isStaff;
		
}

