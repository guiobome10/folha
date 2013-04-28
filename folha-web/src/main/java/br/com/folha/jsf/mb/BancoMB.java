package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Banco;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BancoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class BancoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Banco banco;
	private List<Banco> bancos;

	private BancoFacade facade;
	
	public BancoMB(){
		try {
			facade = FacadeLocator.getService(BancoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		banco = new Banco();
		listar();
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public List<Banco> getBancos() {
		return bancos;
	}

	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

	private void listar() {
		try {
			bancos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(banco);
			JSFUtil.addInfoMessage("Banco adicionado com sucesso!");
			banco = new Banco();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Banco banco){
		try {
			facade.alterar(banco);
			JSFUtil.addInfoMessage("Banco atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(banco);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do banco " + ((Banco)event.getObject()).getNome() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Banco)event.getObject());
    }  

}
