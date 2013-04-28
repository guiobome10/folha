package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoRaisFuncionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoRaisFuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoRaisFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoRaisFuncionario tipoRaisFuncionario;
	private List<TipoRaisFuncionario> tiposRaisFuncionario;

	private TipoRaisFuncionarioFacade facade;
	
	public TipoRaisFuncionarioMB(){
		try {
			facade = FacadeLocator.getService(TipoRaisFuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoRaisFuncionario = new  TipoRaisFuncionario();
		listar();
	}

	public TipoRaisFuncionario getTipoRaisFuncionario() {
		return tipoRaisFuncionario;
	}

	public void setTipoRaisFuncionario(TipoRaisFuncionario tipoRaisFuncionario) {
		this.tipoRaisFuncionario = tipoRaisFuncionario;
	}

	public List<TipoRaisFuncionario> getTiposRaisFuncionario() {
		return tiposRaisFuncionario;
	}

	public void setTiposRaisFuncionario(
			List<TipoRaisFuncionario> tiposRaisFuncionario) {
		this.tiposRaisFuncionario = tiposRaisFuncionario;
	}

	private void listar() {
		try {
			tiposRaisFuncionario = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoRaisFuncionario);
			JSFUtil.addInfoMessage("Tipo de Rais do funcionario adicionado com sucesso!");
			tipoRaisFuncionario = new TipoRaisFuncionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoRaisFuncionario tipoPagamentoFuncionario){
		try {
			facade.alterar(tipoPagamentoFuncionario);
			JSFUtil.addInfoMessage("Tipo de Rais do funcionario atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoRaisFuncionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do tipo de Rais do funcionario " + ((TipoRaisFuncionario)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoRaisFuncionario)event.getObject());
    }  

}
