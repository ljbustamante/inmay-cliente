package com.cliente.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.cibertec.entidad.Categoria;
import com.cibertec.entidad.Producto;
import com.cibertec.entidad.Proveedor;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")
public class ProductoAction extends ActionSupport {
	
	private String URL_PRODUCTO = "http://localhost:8080/inmay-servidor/rest/producto/";
	private String URL_CATEGORIA = "http://localhost:8080/inmay-servidor/rest/categoria/listar";
	private String URL_PROVEEDOR = "http://localhost:8080/inmay-servidor/rest/proveedor/listar";

	//
	private Categoria[] listaCategorias;
	private Producto[] listaProductos;
	private Proveedor[] listaProveedores;
	private Producto producto;
	private int codigo;
	private String dataMensaje;
	private String dataJSON;
	//
	private HttpClient httpClient;
	
	
	private double p1;
	private double p2;
	private List<Producto> listaProductos2;

	public List<Producto> getListaProductos2() {
		return listaProductos2;
	}

	public void setListaProductos2(List<Producto> listaProductos2) {
		this.listaProductos2 = listaProductos2;
	}

	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	
	

	public ProductoAction() {
		httpClient = HttpClientBuilder.create().build();
	}
	

	@Action(value="/prueba", results = {@Result(name="ok", location="/list-prueba.jsp")})
	public String prueba() throws ClientProtocolException, IOException{
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_PRODUCTO+p1+"/"+p2);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaProductos=gson.fromJson(json, Producto[].class);
		listaProductos2 = Arrays.asList(listaProductos);
		return "ok";
	}
	

	@Action(value = "/listAllProveedores", results = { @Result(name = "ok", type = "json") })
	public String listAllProveedores() throws ClientProtocolException, IOException {
		// definir método "GET"
		HttpGet httpGet = new HttpGet(URL_PROVEEDOR);
		// respuesta
		HttpResponse httpResponse = httpClient.execute(httpGet);
		// obtener el valor de la respuesta
		String json = EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson = new Gson();
		listaProveedores = gson.fromJson(json, Proveedor[].class);
		return "ok";
	}

	// Listar Paises
	@Action(value = "/listAllCategorias", results = { @Result(name = "ok", type = "json") })
	public String listAllCategorias() throws ClientProtocolException, IOException {
		// definir método "GET"
		HttpGet httpGet = new HttpGet(URL_CATEGORIA);
		// respuesta
		HttpResponse httpResponse = httpClient.execute(httpGet);
		// obtener el valor de la respuesta
		String json = EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson = new Gson();
		listaCategorias = gson.fromJson(json, Categoria[].class);

		return "ok";
	}

	@Action(value = "/listAllProductos", results = { @Result(name = "ok", type = "json") })
	public String listAllProductos() throws ClientProtocolException, IOException {
		// definir método "GET"
		HttpGet httpGet = new HttpGet(URL_PRODUCTO+"listar");
		// respuesta
		HttpResponse httpResponse = httpClient.execute(httpGet);
		// obtener el valor de la respuesta
		String json = EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson = new Gson();
		listaProductos = gson.fromJson(json, Producto[].class);

		return "ok";
	}

	@Action(value = "/buscarProducto", results = { @Result(name = "ok", type = "json") })
	public String buscarProducto() throws ClientProtocolException, IOException {
		// definir método "GET"
		HttpGet httpGet = new HttpGet(URL_PRODUCTO + codigo);
		// respuesta
		HttpResponse httpResponse = httpClient.execute(httpGet);
		// obtener el valor de la respuesta
		String json = EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson = new Gson();
		producto = gson.fromJson(json, Producto.class);

		return "ok";
	}

	@Action(value = "/eliminarProducto", results = { @Result(name = "ok", type = "json") })
	public String eliminarProducto() throws ClientProtocolException, IOException {
		// definir método "DELETE"
		HttpDelete httpDelete = new HttpDelete(URL_PRODUCTO + codigo);
		// respuesta
		HttpResponse httpResponse = httpClient.execute(httpDelete);
		// obtener el valor de la respuesta
		dataMensaje = EntityUtils.toString(httpResponse.getEntity());

		return "ok";
	}

	@Action(value = "/saveProducto", results = { @Result(name = "ok", type = "json") })
	public String saveProducto() throws ClientProtocolException, IOException {

		if (codigo == 0) {
			// definir método "POST"
			HttpPost httpPost = new HttpPost(URL_PRODUCTO);
			//
			StringEntity string = new StringEntity(dataJSON.toString(), "UTF-8");
			httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
			httpPost.setEntity(string);
			// respuesta
			HttpResponse httpResponse = httpClient.execute(httpPost);
			// obtener el valor de la respuesta
			dataMensaje = EntityUtils.toString(httpResponse.getEntity());
		} else {
			// definir método "PUT"
			HttpPut httpPut = new HttpPut(URL_PRODUCTO);
			//
			StringEntity string = new StringEntity(dataJSON.toString(), "UTF-8");
			httpPut.setHeader("Content-Type", "application/json;charset=UTF-8");
			httpPut.setEntity(string);
			// respuesta
			HttpResponse httpResponse = httpClient.execute(httpPut);
			// obtener el valor de la respuesta
			dataMensaje = EntityUtils.toString(httpResponse.getEntity());
		}

		return "ok";
	}

	public Categoria[] getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(Categoria[] listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public Producto[] getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(Producto[] listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDataMensaje() {
		return dataMensaje;
	}

	public void setDataMensaje(String dataMensaje) {
		this.dataMensaje = dataMensaje;
	}

	public String getDataJSON() {
		return dataJSON;
	}

	public Proveedor[] getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(Proveedor[] listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public void setDataJSON(String dataJSON) {
		this.dataJSON = dataJSON;
	}

}
