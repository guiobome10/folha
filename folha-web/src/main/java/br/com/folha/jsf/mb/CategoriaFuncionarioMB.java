package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.CategoriaFuncionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaFuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CategoriaFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private CategoriaFuncionario categoriaFuncionario;
	private List<CategoriaFuncionario> categoriasFuncionario;

	private CategoriaFuncionarioFacade facade;
	
	public CategoriaFuncionarioMB(){
		try {
			facade = FacadeLocator.getService(CategoriaFuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		categoriaFuncionario = new  CategoriaFuncionario();
		listarCategoriasFuncionario();
	}

	public CategoriaFuncionario getCategoriaFuncionario() {
		return categoriaFuncionario;
	}

	public void setCategoriaFuncionario(CategoriaFuncionario categoriaFuncionario) {
		this.categoriaFuncionario = categoriaFuncionario;
	}

	public List<CategoriaFuncionario> getCategoriasFuncionario() {
		return categoriasFuncionario;
	}

	public void setCategoriasFuncionario(List<CategoriaFuncionario> categoriasFuncionario) {
		this.categoriasFuncionario = categoriasFuncionario;
	}

	private void listarCategoriasFuncionario() {
		try {
			categoriasFuncionario = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(categoriaFuncionario);
			JSFUtil.addInfoMessage("Categoria do funcionario adicionada com sucesso!");
			categoriaFuncionario = new CategoriaFuncionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(CategoriaFuncionario categoriaFuncionario){
		try {
			facade.alterar(categoriaFuncionario);
			JSFUtil.addInfoMessage("Categoria do funcionario atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(categoriaFuncionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da categoria do funcionario " + ((CategoriaFuncionario)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((CategoriaFuncionario)event.getObject());
    }  

}
