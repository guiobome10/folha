package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Turno;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TurnoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class TurnoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Turno turno;
	private List<Turno> turnos;

	private TurnoFacade facade;
	
	public TurnoMB(){
		try {
			facade = FacadeLocator.getService(TurnoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		turno = new  Turno();
		listar();
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	private void listar() {
		try {
			turnos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(turno);
			JSFUtil.addInfoMessage("Turno adicionado com sucesso!");
			turno = new Turno();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Turno turno){
		try {
			facade.alterar(turno);
			JSFUtil.addInfoMessage("Turno atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(turno);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do turno " + ((Turno)event.getObject()).getAsString() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Turno)event.getObject());
    }  

}
