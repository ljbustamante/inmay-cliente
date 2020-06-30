package com.cibertec.entidad;

import java.io.Serializable;

public class EstadoUsuario implements Serializable {
	private int idEstadoUsuario;
	private String descEstadoUsuario;
	
	public int getIdEstadoUsuario() {
		return idEstadoUsuario;
	}
	public void setIdEstadoUsuario(int idEstadoUsuario) {
		this.idEstadoUsuario = idEstadoUsuario;
	}
	public String getDescEstadoUsuario() {
		return descEstadoUsuario;
	}
	public void setDescEstadoUsuario(String descEstadoUsuario) {
		this.descEstadoUsuario = descEstadoUsuario;
	}
}
