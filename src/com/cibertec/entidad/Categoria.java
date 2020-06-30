package com.cibertec.entidad;

import java.io.Serializable;

public class Categoria implements Serializable {
	private int idCategoria;
	private String nombreCat;
	private String descripcionCat;
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombreCat() {
		return nombreCat;
	}
	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}
	public String getDescripcionCat() {
		return descripcionCat;
	}
	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = descripcionCat;
	}

	
}
