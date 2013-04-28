package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Equipamento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EquipamentoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ViewScoped
public class EquipamentoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Equipamento equipamento;
	private List<Equipamento> equipamentos;

	private EquipamentoFacade facade;
	
	public EquipamentoMB(){
		try {
			facade = FacadeLocator.getService(EquipamentoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		equipamento = new Equipamento();
		listar();
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}

	private void listar() {
		try {
			equipamentos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(equipamento);
			JSFUtil.addInfoMessage("Equipamento adicionado com sucesso!");
			equipamento = new Equipamento();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Equipamento equipamento){
		try {
			facade.alterar(equipamento);
			JSFUtil.addInfoMessage("Equipamento atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(equipamento);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do equipamento " + ((Equipamento)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Equipamento)event.getObject());
    }  

}
