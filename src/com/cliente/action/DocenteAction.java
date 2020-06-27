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
import com.cibertec.entidad.DistritoBean;
import com.cibertec.entidad.DocenteBean;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("dawi")
public class DocenteAction extends ActionSupport{
	
	private String URL_DISTRITO="http://localhost:8085/WS_REST_Servidor/rest/distrito/";
	private String URL_DOCENTE="http://localhost:8085/WS_REST_Servidor/rest/docente/";
	
	//
	private DistritoBean[] listaDistritos;
	private DocenteBean[] listaDocentes;
	private DocenteBean docente;
	private int codigo;
	private String dataMensaje;
	private String dataJSON;
	//
	private HttpClient httpClient;
	
	//
	public DocenteAction() {
		httpClient=HttpClientBuilder.create().build();
	}
	

	@Action(value="/listAllDistritos",results= {@Result(name="ok",type="json")})
	public String listAllDistritos() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_DISTRITO);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaDistritos=gson.fromJson(json, DistritoBean[].class);
		
		return "ok";
	}
	@Action(value="/listAllDocentes",results= {@Result(name="ok",type="json")})
	public String listAllDocentes() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_DOCENTE);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		listaDocentes=gson.fromJson(json, DocenteBean[].class);
		
		return "ok";
	}
	@Action(value="/buscarDocente",results= {@Result(name="ok",type="json")})
	public String buscarDocente() throws ClientProtocolException, IOException {
		//definir método "GET"
		HttpGet httpGet=new HttpGet(URL_DOCENTE+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpGet);
		//obtener el valor de la respuesta
		String json=EntityUtils.toString(httpResponse.getEntity());
		//
		Gson gson=new Gson();
		docente=gson.fromJson(json, DocenteBean.class);
		
		return "ok";
	}
	@Action(value="/eliminarDocente",results= {@Result(name="ok",type="json")})
	public String eliminarDocente() throws ClientProtocolException, IOException {
		//definir método "DELETE"
		HttpDelete httpDelete=new HttpDelete(URL_DOCENTE+codigo);
		//respuesta
		HttpResponse httpResponse=httpClient.execute(httpDelete);
		//obtener el valor de la respuesta
		dataMensaje=EntityUtils.toString(httpResponse.getEntity());
		
		return "ok";
	}
	@Action(value="/saveDocente",results= {@Result(name="ok",type="json")})
	public String saveDocente() throws ClientProtocolException, IOException {
		
		
		if(codigo==0) {
			//definir método "POST"
			HttpPost httpPost=new HttpPost(URL_DOCENTE);
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
			HttpPut httpPut=new HttpPut(URL_DOCENTE);
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
	
	
	
	
	public DistritoBean[] getListaDistritos() {
		return listaDistritos;
	}


	public void setListaDistritos(DistritoBean[] listaDistritos) {
		this.listaDistritos = listaDistritos;
	}


	public DocenteBean[] getListaDocentes() {
		return listaDocentes;
	}


	public void setListaDocentes(DocenteBean[] listaDocentes) {
		this.listaDocentes = listaDocentes;
	}


	public DocenteBean getDocente() {
		return docente;
	}


	public void setDocente(DocenteBean docente) {
		this.docente = docente;
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






