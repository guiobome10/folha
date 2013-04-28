package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.CondicaoDependente;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CondicaoDependenteFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CondicaoDependenteMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private CondicaoDependente condicaoDependente;
	private List<CondicaoDependente> condicoesDependente;

	private CondicaoDependenteFacade facade;
	
	public CondicaoDependenteMB(){
		try {
			facade = FacadeLocator.getService(CondicaoDependenteFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		condicaoDependente = new CondicaoDependente();
		listar();
	}
	
	public CondicaoDependente getCondicaoDependente() {
		return condicaoDependente;
	}

	public void setCondicaoDependente(CondicaoDependente condicaoDependente) {
		this.condicaoDependente = condicaoDependente;
	}

	public List<CondicaoDependente> getCondicoesDependente() {
		return condicoesDependente;
	}

	public void setCondicoesDependente(List<CondicaoDependente> condicoesDependente) {
		this.condicoesDependente = condicoesDependente;
	}

	private void listar() {
		try {
			condicoesDependente = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(condicaoDependente);
			JSFUtil.addInfoMessage("Condicao dependente adicionado com sucesso!");
			condicaoDependente = new CondicaoDependente();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(CondicaoDependente condicaoDependente){
		try {
			facade.alterar(condicaoDependente);
			JSFUtil.addInfoMessage("Condicao dependente atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(condicaoDependente);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do condicao dependente" + ((CondicaoDependente)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((CondicaoDependente)event.getObject());
    }  

}
