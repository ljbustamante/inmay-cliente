package com.cibertec.entidad;

import java.io.Serializable;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

public class Producto implements Serializable {
	private int idProducto;
	private String descProducto;
	private int idCategoria;
	private int stock;
	private double precioU;
	private int idProveedor;
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioU() {
		return precioU;
	}
	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	
}
