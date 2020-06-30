package com.cibertec.entidad;

import java.io.Serializable;

public class Provincia implements Serializable {
	private int idProvincia;
	private String descProvincia;
	private int idCiudad;
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getDescProvincia() {
		return descProvincia;
	}
	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	
	
}
