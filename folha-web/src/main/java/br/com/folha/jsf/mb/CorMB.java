package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Cor;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CorFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class CorMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Cor cor;
	private List<Cor> cores;

	private CorFacade facade;
	
	public CorMB(){
		try {
			facade = FacadeLocator.getService(CorFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		cor = new Cor();
		listar();
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public List<Cor> getCores() {
		return cores;
	}

	public void setCores(List<Cor> cors) {
		this.cores = cors;
	}

	private void listar() {
		try {
			cores = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(cor);
			JSFUtil.addInfoMessage("Cor adicionada com sucesso!");
			cor = new Cor();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Cor cor){
		try {
			facade.alterar(cor);
			JSFUtil.addInfoMessage("Cor atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(cor);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da cor " + ((Cor)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Cor)event.getObject());
    }  

}
