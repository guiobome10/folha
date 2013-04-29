package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Deficiencia;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DeficienciaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class DeficienciaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Deficiencia deficiencia;
	private List<Deficiencia> deficiencias;

	private DeficienciaFacade facade;
	
	public DeficienciaMB(){
		try {
			facade = FacadeLocator.getService(DeficienciaFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		deficiencia = new Deficiencia();
		listar();
	}

	public Deficiencia getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Deficiencia deficiencia) {
		this.deficiencia = deficiencia;
	}

	public List<Deficiencia> getDeficiencias() {
		return deficiencias;
	}

	public void setDeficiencias(List<Deficiencia> deficiencias) {
		this.deficiencias = deficiencias;
	}

	private void listar() {
		try {
			deficiencias = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(deficiencia);
			JSFUtil.addInfoMessage("Deficiencia adicionada com sucesso!");
			deficiencia = new Deficiencia();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Deficiencia deficiencia){
		try {
			facade.alterar(deficiencia);
			JSFUtil.addInfoMessage("Deficiencia atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(deficiencia);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da deficiencia " + ((Deficiencia)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Deficiencia)event.getObject());
    }  

}
