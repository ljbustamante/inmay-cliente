package com.cibertec.entidad;

import java.io.Serializable;

public class Rol implements Serializable {
	private int idRol;
	private String descRol;
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getDescRol() {
		return descRol;
	}
	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}
	
}
