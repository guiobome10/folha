package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.BaseInsalubridadeFuncionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BaseInsalubridadeFuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class BaseInsalubridadeFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private BaseInsalubridadeFuncionario baseInsalubridadeFuncionario;
	private List<BaseInsalubridadeFuncionario> baseInsalubridadeFuncionarios;

	private BaseInsalubridadeFuncionarioFacade facade;
	
	public BaseInsalubridadeFuncionarioMB(){
		try {
			facade = FacadeLocator.getService(BaseInsalubridadeFuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		baseInsalubridadeFuncionario = new BaseInsalubridadeFuncionario();
		listar();
	}

	public BaseInsalubridadeFuncionario getBaseInsalubridadeFuncionario() {
		return baseInsalubridadeFuncionario;
	}

	public void setBaseInsalubridadeFuncionario(
			BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) {
		this.baseInsalubridadeFuncionario = baseInsalubridadeFuncionario;
	}

	public List<BaseInsalubridadeFuncionario> getBaseInsalubridadeFuncionarios() {
		return baseInsalubridadeFuncionarios;
	}

	public void setBaseInsalubridadeFuncionarios(
			List<BaseInsalubridadeFuncionario> baseInsalubridadeFuncionarios) {
		this.baseInsalubridadeFuncionarios = baseInsalubridadeFuncionarios;
	}

	private void listar() {
		try {
			baseInsalubridadeFuncionarios = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(baseInsalubridadeFuncionario);
			JSFUtil.addInfoMessage("Base Insalubridade Funcionario adicionado com sucesso!");
			baseInsalubridadeFuncionario = new BaseInsalubridadeFuncionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario){
		try {
			facade.alterar(baseInsalubridadeFuncionario);
			JSFUtil.addInfoMessage("Base Insalubridade Funcionario atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(baseInsalubridadeFuncionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do base Insalubridade Funcionario " + ((BaseInsalubridadeFuncionario)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((BaseInsalubridadeFuncionario)event.getObject());
    }  

}
