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
	private int idRol;
	private int idEstadoUsuario;
	private boolean isStaff;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreU() {
		return nombreU;
	}
	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}
	public String getApellidoU() {
		return apellidoU;
	}
	public void setApellidoU(String apellidoU) {
		this.apellidoU = apellidoU;
	}
	public String getEmailU() {
		return emailU;
	}
	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}
	public String getClaveU() {
		return claveU;
	}
	public void setClaveU(String claveU) {
		this.claveU = claveU;
	}
	public Date getfRegistroU() {
		return fRegistroU;
	}
	public void setfRegistroU(Date fRegistroU) {
		this.fRegistroU = fRegistroU;
	}
	public String getDireccionU() {
		return direccionU;
	}
	public void setDireccionU(String direccionU) {
		this.direccionU = direccionU;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getTelefonoU() {
		return telefonoU;
	}
	public void setTelefonoU(String telefonoU) {
		this.telefonoU = telefonoU;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdEstadoUsuario() {
		return idEstadoUsuario;
	}
	public void setIdEstadoUsuario(int idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}
	public boolean isStaff() {
		return isStaff;
	}
	public void setStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}
		
}

