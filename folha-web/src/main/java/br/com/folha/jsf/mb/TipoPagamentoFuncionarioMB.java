package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoPagamentoFuncionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoPagamentoFuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoPagamentoFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoPagamentoFuncionario tipoPagamentoFuncionario;
	private List<TipoPagamentoFuncionario> tiposPagamentoFuncionario;

	private TipoPagamentoFuncionarioFacade facade;
	
	public TipoPagamentoFuncionarioMB(){
		try {
			facade = FacadeLocator.getService(TipoPagamentoFuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoPagamentoFuncionario = new  TipoPagamentoFuncionario();
		listar();
	}

	public TipoPagamentoFuncionario getTipoPagamentoFuncionario() {
		return tipoPagamentoFuncionario;
	}

	public void setTipoPagamentoFuncionario(
			TipoPagamentoFuncionario tipoPagamentoFuncionario) {
		this.tipoPagamentoFuncionario = tipoPagamentoFuncionario;
	}

	public List<TipoPagamentoFuncionario> getTiposPagamentoFuncionario() {
		return tiposPagamentoFuncionario;
	}

	public void setTiposPagamentoFuncionario(
			List<TipoPagamentoFuncionario> tiposPagamentoFuncionario) {
		this.tiposPagamentoFuncionario = tiposPagamentoFuncionario;
	}

	private void listar() {
		try {
			tiposPagamentoFuncionario = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoPagamentoFuncionario);
			JSFUtil.addInfoMessage("Tipo de pagamento de funcionario adicionado com sucesso!");
			tipoPagamentoFuncionario = new TipoPagamentoFuncionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoPagamentoFuncionario tipoPagamentoFuncionario){
		try {
			facade.alterar(tipoPagamentoFuncionario);
			JSFUtil.addInfoMessage("Tipo de pagamento de funcionario atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoPagamentoFuncionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do tipo de pagamento de funcionario " + ((TipoPagamentoFuncionario)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoPagamentoFuncionario)event.getObject());
    }  

}
