package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.EstadoCivil;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EstadoCivilFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class EstadoCivilMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private EstadoCivil estadoCivil;
	private List<EstadoCivil> estadosCivil;

	private EstadoCivilFacade facade;
	
	public EstadoCivilMB(){
		try {
			facade = FacadeLocator.getService(EstadoCivilFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		estadoCivil = new EstadoCivil();
		listar();
	}
	
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<EstadoCivil> getEstadosCivil() {
		return estadosCivil;
	}

	public void setEstadosCivil(List<EstadoCivil> estadosCivil) {
		this.estadosCivil = estadosCivil;
	}

	private void listar() {
		try {
			estadosCivil = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(estadoCivil);
			JSFUtil.addInfoMessage("Estado civil adicionado com sucesso!");
			estadoCivil = new EstadoCivil();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(EstadoCivil estadoCivil){
		try {
			facade.alterar(estadoCivil);
			JSFUtil.addInfoMessage("Estado civil atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(estadoCivil);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do estado civil" + ((EstadoCivil)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((EstadoCivil)event.getObject());
    }  

}
