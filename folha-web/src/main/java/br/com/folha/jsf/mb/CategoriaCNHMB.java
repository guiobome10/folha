package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.CategoriaCNH;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaCNHFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CategoriaCNHMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private CategoriaCNH categoriaCNH ;
	private List<CategoriaCNH> categoriasCNH;

	private CategoriaCNHFacade facade;
	
	public CategoriaCNHMB(){
		try {
			facade = FacadeLocator.getService(CategoriaCNHFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		categoriaCNH = new  CategoriaCNH();
		listar();
	}

	public CategoriaCNH getCategoriaCNH() {
		return categoriaCNH;
	}

	public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
		this.categoriaCNH = categoriaCNH;
	}

	public List<CategoriaCNH> getCategoriasCNH() {
		return categoriasCNH;
	}

	public void setCategoriasCNH(List<CategoriaCNH> categoriasCNH) {
		this.categoriasCNH = categoriasCNH;
	}

	private void listar() {
		try {
			categoriasCNH = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(categoriaCNH);
			JSFUtil.addInfoMessage("Categoria CNH adicionada com sucesso!");
			categoriaCNH = new CategoriaCNH();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(CategoriaCNH categoriaFuncionario){
		try {
			facade.alterar(categoriaFuncionario);
			JSFUtil.addInfoMessage("Categoria CNH atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(categoriaCNH);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da categoria CNH " + ((CategoriaCNH)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((CategoriaCNH)event.getObject());
    }  

}
