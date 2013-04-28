package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Escolaridade;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EscolaridadeFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class EscolaridadeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Escolaridade escolaridade;
	private List<Escolaridade> escolaridades;

	private EscolaridadeFacade facade;
	
	public EscolaridadeMB(){
		try {
			facade = FacadeLocator.getService(EscolaridadeFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		escolaridade = new Escolaridade();
		listar();
	}

	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<Escolaridade> getEscolaridades() {
		return escolaridades;
	}

	public void setEscolaridades(List<Escolaridade> escolaridades) {
		this.escolaridades = escolaridades;
	}

	private void listar() {
		try {
			escolaridades = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(escolaridade);
			JSFUtil.addInfoMessage("Escolaridade adicionado com sucesso!");
			escolaridade = new Escolaridade();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Escolaridade escolaridade){
		try {
			facade.alterar(escolaridade);
			JSFUtil.addInfoMessage("Escolaridade atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(escolaridade);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do escolaridade " + ((Escolaridade)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Escolaridade)event.getObject());
    }  

}
