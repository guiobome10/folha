package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoFGTSEmpresa;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoFGTSEmpresaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoFGTSEmpresaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoFGTSEmpresa tipoFGTSEmpresa;
	private List<TipoFGTSEmpresa> tiposFGTSEmpresa;

	private TipoFGTSEmpresaFacade facade;
	
	public TipoFGTSEmpresaMB(){
		try {
			facade = FacadeLocator.getService(TipoFGTSEmpresaFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoFGTSEmpresa = new TipoFGTSEmpresa();
		listar();
	}


	public TipoFGTSEmpresa getTipoFGTSEmpresa() {
		return tipoFGTSEmpresa;
	}


	public void setTipoFGTSEmpresa(TipoFGTSEmpresa tipoFGTSEmpresa) {
		this.tipoFGTSEmpresa = tipoFGTSEmpresa;
	}


	public List<TipoFGTSEmpresa> getTiposFGTSEmpresa() {
		return tiposFGTSEmpresa;
	}


	public void setTiposFGTSEmpresa(List<TipoFGTSEmpresa> tiposFGTSEmpresa) {
		this.tiposFGTSEmpresa = tiposFGTSEmpresa;
	}


	private void listar() {
		try {
			tiposFGTSEmpresa = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoFGTSEmpresa);
			JSFUtil.addInfoMessage("Natureza da empresa adicionada com sucesso!");
			tipoFGTSEmpresa = new TipoFGTSEmpresa();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoFGTSEmpresa categoriaEmpresa){
		try {
			facade.alterar(categoriaEmpresa);
			JSFUtil.addInfoMessage("Natureza da empresa atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoFGTSEmpresa);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da natureza da empresa " + ((TipoFGTSEmpresa)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoFGTSEmpresa)event.getObject());
    }  

}
