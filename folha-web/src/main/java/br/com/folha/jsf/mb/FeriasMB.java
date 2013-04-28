package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Ferias;
import br.com.folha.enuns.PeriodoAquisitivo;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FeriasFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class FeriasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Ferias ferias;
	private List<Ferias> feriasList;
	private List<SelectItem> periodosAquisitivos = new ArrayList<SelectItem>();

	private FeriasFacade facade;
	
	public FeriasMB(){
		try {
			facade = FacadeLocator.getService(FeriasFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		ferias = new Ferias();
		listar();
	}

	public Ferias getFerias() {
		return ferias;
	}

	public void setFerias(Ferias ferias) {
		this.ferias = ferias;
	}

	public List<Ferias> getFeriasList() {
		return feriasList;
	}

	public void setFeriasList(List<Ferias> feriasList) {
		this.feriasList = feriasList;
	}

	public List<SelectItem> getPeriodosAquisitivos() {
		return periodosAquisitivos;
	}

	public void setPeriodosAquisitivos(List<SelectItem> periodosAquisitivos) {
		this.periodosAquisitivos = periodosAquisitivos;
	}

	private void listar() {
		try {
			feriasList = facade.listar();
			PeriodoAquisitivo[] p = PeriodoAquisitivo.values();
			for(int i = 0; i < PeriodoAquisitivo.values().length; i++){
				periodosAquisitivos.add(new SelectItem(p[i]));
			}
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(ferias);
			JSFUtil.addInfoMessage("Ferias adicionada com sucesso!");
			ferias = new Ferias();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Ferias ferias){
		try {
			facade.alterar(ferias);
			JSFUtil.addInfoMessage("Ferias atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(ferias);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição das ferias " + ((Ferias)event.getObject())+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Ferias)event.getObject());
    }  

}
