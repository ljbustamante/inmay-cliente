package com.cibertec.entidad;

import java.io.Serializable;

public class Pais implements Serializable {
	private int idPais;
	private String descPais;
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public String getDescPais() {
		return descPais;
	}
	public void setDescPais(String descPais) {
		this.descPais = descPais;
	}
	
	
}
