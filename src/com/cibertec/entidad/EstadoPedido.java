package com.cibertec.entidad;

import java.io.Serializable;

public class EstadoPedido implements Serializable {
	private int idEstadoPedido;
	private String descEstadoPedido;
	public int getIdEstadoPedido() {
		return idEstadoPedido;
	}
	public void setIdEstadoPedido(int idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}
	public String getDescEstadoPedido() {
		return descEstadoPedido;
	}
	public void setDescEstadoPedido(String descEstadoPedido) {
		this.descEstadoPedido = descEstadoPedido;
	}
	
	
}
