package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.TipoEquipamento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoEquipamentoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TipoEquipamentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private TipoEquipamento tipoEquipamento;
	private List<TipoEquipamento> tipoEquipamentos;

	private TipoEquipamentoFacade facade;
	
	public TipoEquipamentoMB(){
		try {
			facade = FacadeLocator.getService(TipoEquipamentoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		tipoEquipamento = new TipoEquipamento();
		listar();
	}

	public TipoEquipamento getTipoEquipamento() {
		return tipoEquipamento;
	}

	public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
		this.tipoEquipamento = tipoEquipamento;
	}

	public List<TipoEquipamento> getTipoEquipamentos() {
		return tipoEquipamentos;
	}

	public void setTipoEquipamentos(List<TipoEquipamento> tipoEquipamentos) {
		this.tipoEquipamentos = tipoEquipamentos;
	}

	private void listar() {
		try {
			tipoEquipamentos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(tipoEquipamento);
			JSFUtil.addInfoMessage("Tipo equipamento adicionado com sucesso!");
			tipoEquipamento = new TipoEquipamento();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(TipoEquipamento tipoEquipamento){
		try {
			facade.alterar(tipoEquipamento);
			JSFUtil.addInfoMessage("Tipo equipamento atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(tipoEquipamento);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do tipo equipamento " + ((TipoEquipamento)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((TipoEquipamento)event.getObject());
    }  

}
