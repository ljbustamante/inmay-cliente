package com.cibertec.entidad;

import java.io.Serializable;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

public class PedidoDetalle implements Serializable {
	private int idPedidoDetalle;
	private int idPedido;
	private int idProducto;
	public int getIdPedidoDetalle() {
		return idPedidoDetalle;
	}
	public void setIdPedidoDetalle(int idPedidoDetalle) {
		this.idPedidoDetalle = idPedidoDetalle;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
}
