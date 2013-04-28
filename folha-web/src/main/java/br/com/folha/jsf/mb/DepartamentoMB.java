package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Departamento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DepartamentoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class DepartamentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Departamento departamento;
	private List<Departamento> departamentos;

	private DepartamentoFacade facade;
	
	public DepartamentoMB(){
		try {
			facade = FacadeLocator.getService(DepartamentoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		departamento = new  Departamento();
		listar();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	private void listar() {
		try {
			departamentos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(departamento);
			JSFUtil.addInfoMessage("Departamento adicionado com sucesso!");
			departamento = new Departamento();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Departamento departamento){
		try {
			facade.alterar(departamento);
			JSFUtil.addInfoMessage("Departamento atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(departamento);
			JSFUtil.addInfoMessage("Departamento excluído com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do departamento " + ((Departamento)event.getObject()).getNome() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Departamento)event.getObject());
    }  

}
