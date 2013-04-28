package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoJornada;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoJornadaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoJornadaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoJornada tipoJornada;
	private List<TipoJornada> tiposJornada;

	private TipoJornadaFacade facade;
	
	public TipoJornadaMB(){
		try {
			facade = FacadeLocator.getService(TipoJornadaFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoJornada = new  TipoJornada();
		listar();
	}

	public TipoJornada getTipoJornada() {
		return tipoJornada;
	}

	public void setTipoJornada(TipoJornada tipoJornada) {
		this.tipoJornada = tipoJornada;
	}

	public List<TipoJornada> getTiposJornada() {
		return tiposJornada;
	}

	public void setTiposJornada(List<TipoJornada> tiposJornada) {
		this.tiposJornada = tiposJornada;
	}

	private void listar() {
		try {
			tiposJornada = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoJornada);
			JSFUtil.addInfoMessage("Tipo de jornada adicionada com sucesso!");
			tipoJornada = new TipoJornada();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoJornada tipoJornada){
		try {
			facade.alterar(tipoJornada);
			JSFUtil.addInfoMessage("Tipo de jornada atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoJornada);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do tipo de jornada " + ((TipoJornada)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoJornada)event.getObject());
    }  

}
