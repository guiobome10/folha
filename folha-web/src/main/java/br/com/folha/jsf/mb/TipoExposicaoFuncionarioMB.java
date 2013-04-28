package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoExposicaoFuncionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoExposicaoFuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoExposicaoFuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoExposicaoFuncionario tipoExposicaooFuncionario;
	private List<TipoExposicaoFuncionario> tiposExposicaoFuncionario;

	private TipoExposicaoFuncionarioFacade facade;
	
	public TipoExposicaoFuncionarioMB(){
		try {
			facade = FacadeLocator.getService(TipoExposicaoFuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoExposicaooFuncionario = new  TipoExposicaoFuncionario();
		listar();
	}

	public TipoExposicaoFuncionario getTipoExposicaooFuncionario() {
		return tipoExposicaooFuncionario;
	}

	public void setTipoExposicaooFuncionario(
			TipoExposicaoFuncionario tipoExposicaooFuncionario) {
		this.tipoExposicaooFuncionario = tipoExposicaooFuncionario;
	}

	public List<TipoExposicaoFuncionario> getTiposExposicaoFuncionario() {
		return tiposExposicaoFuncionario;
	}

	public void setTiposExposicaoFuncionario(
			List<TipoExposicaoFuncionario> tiposExposicaoFuncionario) {
		this.tiposExposicaoFuncionario = tiposExposicaoFuncionario;
	}

	private void listar() {
		try {
			tiposExposicaoFuncionario = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoExposicaooFuncionario);
			JSFUtil.addInfoMessage("Tipo de exposicao do funcionario adicionado com sucesso!");
			tipoExposicaooFuncionario = new TipoExposicaoFuncionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoExposicaoFuncionario tipoPagamentoFuncionario){
		try {
			facade.alterar(tipoPagamentoFuncionario);
			JSFUtil.addInfoMessage("Tipo de exposicao do funcionario atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoExposicaooFuncionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do tipo de exposicao do funcionario " + ((TipoExposicaoFuncionario)event.getObject()).getDescricao() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoExposicaoFuncionario)event.getObject());
    }  

}
