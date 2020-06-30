package com.cliente.action;

import java.io.IOException;

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
import com.cibertec.entidad.DistritoBean;
import com.cibertec.entidad.DocenteBean;
import com.cibertec.entidad.Pais;
import com.cibertec.entidad.Producto;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")
public class ProductoAction extends ActionSupport {
	
	private String URL_PRODUCTO="http://localhost:8080/inmay-servidor/rest/cliente/";
	private String URL_CATEGORIA="";
	
	//
	private Categoria[] listaCategorias;
	private Producto[] listaProductos;
	private Producto producto;
	private int codigo;
	private String dataMensaje;
	private String dataJSON;
	//
	private HttpClient httpClient;
	
	public ProductoAction() {
		httpClient=HttpClientBuilder.create().build();
	}
	
	
	//Listar Paises
	@Action(value="/listAllCategorias",results= {@Result(name="ok",type="json")})
	public String listAllDistritos() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_CATEGORIA);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaCategorias=gson.fromJson(json, Categoria[].class);
		
		return "ok";
	}
	
	@Action(value="/listAllProductos",results= {@Result(name="ok",type="json")})
	public String listAllDocentes() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_PRODUCTO);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaProductos=gson.fromJson(json, Producto[].class);
		
		return "ok";
	}
	@Action(value="/buscarProducto",results= {@Result(name="ok",type="json")})
	public String buscarDocente() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_PRODUCTO+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		producto=gson.fromJson(json, Producto.class);
		
		return "ok";
	}
	@Action(value="/eliminarProducto",results= {@Result(name="ok",type="json")})
	public String eliminarDocente() throws ClientProtocolException, IOException {
		//definir método "DELETE"
		HttpDelete httpDelete=new HttpDelete(URL_PRODUCTO+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpDelete);
		//obtener el valor de la respuesta
		dataMensaje=EntityUtils.toString(httpResponse.getEntity());
		
		return "ok";
	}
	@Action(value="/saveProducto",results= {@Result(name="ok",type="json")})
	public String saveDocente() throws ClientProtocolException, IOException {
		
		
		if(codigo==0) {
			//definir método "POST"
			HttpPost httpPost=new HttpPost(URL_PRODUCTO);
			//
			StringEntity string=new StringEntity(dataJSON.toString(),"UTF-8");
			httpPost.setHeader("Content-Type","application/json;charset=UTF-8");
			httpPost.setEntity(string);
			//respuesta
			HttpResponse httpResponse=httpClient.execute(httpPost);
			//obtener el valor de la respuesta
			dataMensaje=EntityUtils.toString(httpResponse.getEntity());
		}
		else {
			//definir método "PUT"
			HttpPut httpPut=new HttpPut(URL_PRODUCTO);
			//
			StringEntity string=new StringEntity(dataJSON.toString(),"UTF-8");
			httpPut.setHeader("Content-Type","application/json;charset=UTF-8");
			httpPut.setEntity(string);
			//respuesta
			HttpResponse httpResponse=httpClient.execute(httpPut);
			//obtener el valor de la respuesta
			dataMensaje=EntityUtils.toString(httpResponse.getEntity());
		}
		
		return "ok";
	}
	

}
