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

import com.cibertec.entidad.Proveedor;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("dawi")
public class ProveedorAction extends ActionSupport {
	
	private String URL_PROVEEDOR="http://localhost:8080/inmay-servidor/rest/proveedor/";
	
	//
	private Proveedor[] listaProveedores;
	private Proveedor proveedor;
	private int codigo;
	private String dataMensaje;
	private String dataJSON;
	//
	private HttpClient httpClient;
	
	public ProveedorAction() {
		httpClient=HttpClientBuilder.create().build();
	}
	
	@Action(value="/listarProveedores",results= {@Result(name="ok",type="json")})
	public String listAllProveedores() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_PROVEEDOR+"listar");
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaProveedores=gson.fromJson(json, Proveedor[].class);
		
		return "ok";
	}
	@Action(value="/buscarProveedor",results= {@Result(name="ok",type="json")})
	public String buscarProveedor() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_PROVEEDOR+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		proveedor=gson.fromJson(json, Proveedor.class);
		
		return "ok";
	}
	@Action(value="/eliminarProveedor",results= {@Result(name="ok",type="json")})
	public String eliminarProveedor() throws ClientProtocolException, IOException {
		//definir método "DELETE"
		HttpDelete httpDelete=new HttpDelete(URL_PROVEEDOR+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpDelete);
		//obtener el valor de la respuesta
		dataMensaje=EntityUtils.toString(httpResponse.getEntity());
		
		return "ok";
	}
	@Action(value="/guardarProveedor",results= {@Result(name="ok",type="json")})
	public String guardarProveedor() throws ClientProtocolException, IOException {
		
		
		if(codigo==0) {
			//definir método "POST"
			HttpPost httpPost=new HttpPost(URL_PROVEEDOR);
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
			HttpPut httpPut=new HttpPut(URL_PROVEEDOR);
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

	public Proveedor[] getListaProveedores() {
		return listaProveedores;
	}

	public void setListaProveedores(Proveedor[] listaProveedores) {
		this.listaProveedores = listaProveedores;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

	public void setDataJSON(String dataJSON) {
		this.dataJSON = dataJSON;
	}
	

}
