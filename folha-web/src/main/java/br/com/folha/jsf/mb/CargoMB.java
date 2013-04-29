package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import br.com.folha.entity.Cargo;
import br.com.folha.entity.Departamento;
import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CargoFacade;
import br.com.folha.facade.DepartamentoFacade;
import br.com.folha.facade.SindicatoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ViewScoped
public class CargoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Cargo cargo;
	private List<Cargo> cargos;
	private Sindicato sindicato;
	private Departamento departamento;
	private List<Sindicato> sindicatos;
	private List<Departamento> departamentos;

	private CargoFacade facade;
	private DepartamentoFacade departamentoFacade;
	private SindicatoFacade sindicatoFacade;
	
	public CargoMB(){
		try {
			facade = FacadeLocator.getService(CargoFacade.class);
			departamentoFacade = FacadeLocator.getService(DepartamentoFacade.class);
			sindicatoFacade = FacadeLocator.getService(SindicatoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		cargo = new Cargo();
		listar();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
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
			cargos = facade.listar();
			sindicatos = sindicatoFacade.listar();
			departamentos = (sindicatos.size() > 0 ? departamentoFacade.listarDepartamentosPorSindicato(sindicatos.get(0)) : new ArrayList<Departamento>());
			sindicato = (sindicatos.size() > 0 ? sindicatos.get(0) : null);
			departamento = (departamentos.size() > 0 ? departamentos.get(0) : null);
			cargo.setDepartamento(departamento);
			cargo.getDepartamento().setSindicato(sindicato);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(cargo);
			JSFUtil.addInfoMessage("Cargo adicionado com sucesso!");
			cargo = new Cargo();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(){
		try {
			facade.alterar(cargo);
			JSFUtil.addInfoMessage("Cargo atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void alterar(Cargo cargo){
		try {
			facade.alterar(cargo);
			JSFUtil.addInfoMessage("Cargo atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void excluir(){
		try {
			facade.excluir(cargo);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do cargo " + ((Cargo)event.getObject()).getNome() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Cargo)event.getObject());
    }  

	public void handleSindicatoChange(){
    	if(sindicato != null ){
    		cargo.getDepartamento().setSindicato(sindicato);
    		try {
				this.departamentos = departamentoFacade.listarDepartamentosPorSindicato(cargo.getDepartamento().getSindicato());
				cargo.setDepartamento(departamentos.size() > 0 ? departamentos.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}else{
    		cargo.getDepartamento().setSindicato(sindicato);
    		departamentos = new ArrayList<Departamento>();
    	}
    }

	public void handleDepartamentoChange(){
		if(departamento != null ){
			cargo.setDepartamento(departamento);
			try {
				this.cargos = facade.listarCargosPorDepartamento(cargo.getDepartamento());
				cargo.setNome(cargos.size() > 0 ? cargos.get(0).getNome() : "");
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}else{
			cargo.setDepartamento(departamento);
			cargos = new ArrayList<Cargo>();
		}
	}
	
	public List<Sindicato> getSindicatos() {
		return sindicatos;
	}

	public void setSindicatos(List<Sindicato> sindicatos) {
		this.sindicatos = sindicatos;
	}
	public void atualizaCargo(SelectEvent event){
		this.cargo = (Cargo) event.getObject(); 
	}
}
