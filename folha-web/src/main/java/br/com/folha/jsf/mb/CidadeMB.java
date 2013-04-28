package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Cidade;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CidadeMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Cidade cidade;
	private List<Cidade> cidades;

	private CidadeFacade facade;
	
	public CidadeMB(){
		try {
			facade = FacadeLocator.getService(CidadeFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		cidade = new Cidade();
	}

	
	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


	public List<Cidade> getCidades() {
		if(cidades == null){
			try {
				cidades = facade.listar();
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}


	public void inserir(){
		try {
			facade.inserir(cidade);
			JSFUtil.addInfoMessage("Cidade adicionada com sucesso!");
			cidade = new Cidade();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Cidade cidade){
		try {
			facade.alterar(cidade);
			JSFUtil.addInfoMessage("Cidade atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(cidade);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da cidade " + ((Cidade)event.getObject()).getNome() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Cidade)event.getObject());
    }  

}
