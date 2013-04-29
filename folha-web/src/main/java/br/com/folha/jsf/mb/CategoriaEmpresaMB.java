package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.CategoriaEmpresa;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaEmpresaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CategoriaEmpresaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private CategoriaEmpresa categoriaEmpresa;
	private List<CategoriaEmpresa> categoriasEmpresa;

	private CategoriaEmpresaFacade facade;
	
	public CategoriaEmpresaMB(){
		try {
			facade = FacadeLocator.getService(CategoriaEmpresaFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		categoriaEmpresa = new CategoriaEmpresa();
		listarCategoriasEmpresa();
	}

	
	public CategoriaEmpresa getCategoriaEmpresa() {
		return categoriaEmpresa;
	}


	public void setCategoriaEmpresa(CategoriaEmpresa categoriaEmpresa) {
		this.categoriaEmpresa = categoriaEmpresa;
	}


	public List<CategoriaEmpresa> getCategoriasEmpresa() {
		return categoriasEmpresa;
	}


	public void setCategoriasEmpresa(List<CategoriaEmpresa> categoriasEmpresa) {
		this.categoriasEmpresa = categoriasEmpresa;
	}


	private void listarCategoriasEmpresa() {
		try {
			categoriasEmpresa = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(categoriaEmpresa);
			JSFUtil.addInfoMessage("Categoria da empresa adicionada com sucesso!");
			categoriaEmpresa = new CategoriaEmpresa();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(CategoriaEmpresa categoriaEmpresa){
		try {
			facade.alterar(categoriaEmpresa);
			JSFUtil.addInfoMessage("Categoria da empresa atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(categoriaEmpresa);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da categoria da empresa " + ((CategoriaEmpresa)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((CategoriaEmpresa)event.getObject());
    }  

}
