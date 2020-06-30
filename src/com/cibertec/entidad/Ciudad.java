package com.cibertec.entidad;

import java.io.Serializable;

public class Ciudad implements Serializable {
	private int idCiudad;
	private String descCiudad;
	private int idPais;
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getDescCiudad() {
		return descCiudad;
	}
	public void setDescCiudad(String descCiudad) {
		this.descCiudad = descCiudad;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	
}
