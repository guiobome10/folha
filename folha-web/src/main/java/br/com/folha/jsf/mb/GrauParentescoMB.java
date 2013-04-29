package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.GrauParentesco;
import br.com.folha.exception.AppException;
import br.com.folha.facade.GrauParentescoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class GrauParentescoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private GrauParentesco grauParentesco;
	private List<GrauParentesco> grausParentesco;

	private GrauParentescoFacade facade;
	
	public GrauParentescoMB(){
		try {
			facade = FacadeLocator.getService(GrauParentescoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		grauParentesco = new GrauParentesco();
		listar();
	}
	
	public GrauParentesco getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(GrauParentesco grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public List<GrauParentesco> getGrausParentesco() {
		return grausParentesco;
	}

	public void setGrausParentesco(List<GrauParentesco> grausParentesco) {
		this.grausParentesco = grausParentesco;
	}

	private void listar() {
		try {
			grausParentesco = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(grauParentesco);
			JSFUtil.addInfoMessage("Grau Parentesco adicionado com sucesso!");
			grauParentesco = new GrauParentesco();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(GrauParentesco grauParentesco){
		try {
			facade.alterar(grauParentesco);
			JSFUtil.addInfoMessage("Grau Parentesco atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(grauParentesco);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do grau parentesco" + ((GrauParentesco)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((GrauParentesco)event.getObject());
    }  

}
