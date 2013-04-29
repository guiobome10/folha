package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.NaturezaEmpresa;
import br.com.folha.exception.AppException;
import br.com.folha.facade.NaturezaEmpresaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class NaturezaEmpresaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private NaturezaEmpresa naturezaEmpresa;
	private List<NaturezaEmpresa> naturezasEmpresa;

	private NaturezaEmpresaFacade facade;
	
	public NaturezaEmpresaMB(){
		try {
			facade = FacadeLocator.getService(NaturezaEmpresaFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		naturezaEmpresa = new NaturezaEmpresa();
		listar();
	}


	public NaturezaEmpresa getNaturezaEmpresa() {
		return naturezaEmpresa;
	}


	public void setNaturezaEmpresa(NaturezaEmpresa naturezaEmpresa) {
		this.naturezaEmpresa = naturezaEmpresa;
	}


	public List<NaturezaEmpresa> getNaturezasEmpresa() {
		return naturezasEmpresa;
	}


	public void setNaturezasEmpresa(List<NaturezaEmpresa> naturezasEmpresa) {
		this.naturezasEmpresa = naturezasEmpresa;
	}


	private void listar() {
		try {
			naturezasEmpresa = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(naturezaEmpresa);
			JSFUtil.addInfoMessage("Natureza da empresa adicionada com sucesso!");
			naturezaEmpresa = new NaturezaEmpresa();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(NaturezaEmpresa categoriaEmpresa){
		try {
			facade.alterar(categoriaEmpresa);
			JSFUtil.addInfoMessage("Natureza da empresa atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(naturezaEmpresa);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da natureza da empresa " + ((NaturezaEmpresa)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((NaturezaEmpresa)event.getObject());
    }  

}
