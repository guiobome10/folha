package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Estado;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EstadoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ApplicationScoped
public class EstadoMB implements Serializable{

	private static final long serialVersionUID = -1423012253223570820L;

	private Estado estado;
	private List<Estado> estados;

	private EstadoFacade facade;
	
	public EstadoMB(){
		try {
			facade = FacadeLocator.getService(EstadoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		estado = new Estado();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		if(estados == null){
			try {
				estados = facade.listar();
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}
		return estados;
	}

	public void inserir(){
		try {
			facade.inserir(estado);
			JSFUtil.addInfoMessage("Estado adicionado com sucesso!");
			estado = new Estado();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(){
		try {
			facade.alterar(estado);
			JSFUtil.addInfoMessage("Estado atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(estado);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do estado " + ((Estado)event.getObject()).getNome() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {
    	this.estado = (Estado)event.getObject();
    	alterar();
    }  

    public Estado getEstadoPorSigla(String sigla){
    	for(Estado estado : getEstados()){
    		if(estado.getSigla().equals(sigla))
    			return estado;
    	}
    	return null;
    }
}
