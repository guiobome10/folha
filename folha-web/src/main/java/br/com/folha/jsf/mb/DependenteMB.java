package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Dependente;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DependenteFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class DependenteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Dependente dependente;
	private List<Dependente> dependentes;

	private DependenteFacade facade;

	public DependenteMB() {
		try {
			facade = FacadeLocator.getService(DependenteFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		dependente = new Dependente();
		listar();
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	private void listar() {
		try {
			dependentes = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void inserir() {
		try {
			facade.inserir(dependente);
			JSFUtil.addInfoMessage("Dependente adicionado com sucesso!");
			dependente = new Dependente();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void alterar(Dependente dependente) {
		try {
			facade.alterar(dependente);
			JSFUtil.addInfoMessage("Dependente atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir() {
		try {
			facade.excluir(dependente);
			JSFUtil.addInfoMessage("Dependente exclu�do com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void onCancel(RowEditEvent event) {
		JSFUtil.addInfoMessage("Edição do dependente "
				+ ((Dependente) event.getObject()).getNome() + " foi cancelada");
	}

	public void onEdit(RowEditEvent event) {
		alterar((Dependente) event.getObject());
	}

}
