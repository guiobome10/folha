package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Nacionalidade;
import br.com.folha.exception.AppException;
import br.com.folha.facade.NacionalidadeFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class NacionalidadeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Nacionalidade nacionalidade;
	private List<Nacionalidade> nacionalidades;

	private NacionalidadeFacade facade;
	
	public NacionalidadeMB(){
		try {
			facade = FacadeLocator.getService(NacionalidadeFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		nacionalidade = new Nacionalidade();
		listar();
	}

	public Nacionalidade getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(Nacionalidade nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Nacionalidade> getNacionalidades() {
		return nacionalidades;
	}

	public void setNacionalidades(List<Nacionalidade> nacionalidades) {
		this.nacionalidades = nacionalidades;
	}

	private void listar() {
		try {
			nacionalidades = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(nacionalidade);
			JSFUtil.addInfoMessage("Nacionalidade adicionada com sucesso!");
			nacionalidade = new Nacionalidade();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Nacionalidade nacionalidade){
		try {
			facade.alterar(nacionalidade);
			JSFUtil.addInfoMessage("Nacionalidade atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(nacionalidade);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da nacionalidade " + ((Nacionalidade)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Nacionalidade)event.getObject());
    }  

}
