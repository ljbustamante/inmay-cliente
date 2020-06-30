package com.cibertec.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.eclipse.jdt.core.compiler.CategorizedProblem;

public class Pedido implements Serializable {
	private int idPedido;
	private int idUsuario;
	private Date fPedido;
	private Date fEntrega;
	private int idEstadoPedido;
	private String destinatario;
	private String direccion;
	private int idPais;
	private int idCiudad;
	private int idProvincia;
	private int idDistrito;
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Date getfPedido() {
		return fPedido;
	}
	public void setfPedido(Date fPedido) {
		this.fPedido = fPedido;
	}
	public Date getfEntrega() {
		return fEntrega;
	}
	public void setfEntrega(Date fEntrega) {
		this.fEntrega = fEntrega;
	}
	public int getIdEstadoPedido() {
		return idEstadoPedido;
	}
	public void setIdEstadoPedido(int idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	
}
