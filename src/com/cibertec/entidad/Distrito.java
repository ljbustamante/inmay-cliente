package com.cibertec.entidad;

import java.io.Serializable;

public class Distrito implements Serializable {
	private int idDistrito;
	private String descDistrito;
	private int idProvincia;
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getDescDistrito() {
		return descDistrito;
	}
	public void setDescDistrito(String descDistrito) {
		this.descDistrito = descDistrito;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}

	
}
