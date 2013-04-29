package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Falta;
import br.com.folha.entity.Funcionario;
import br.com.folha.enuns.TipoFalta;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FaltaFacade;
import br.com.folha.facade.FuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class FaltaMB implements Serializable{

	private static final long serialVersionUID = 1L;

	private Falta falta;
	private List<Falta> faltas;

	private FaltaFacade facade;
	private FuncionarioFacade funcionarioFacade;
	
	public FaltaMB(){
		try {
			facade = FacadeLocator.getService(FaltaFacade.class);
			funcionarioFacade = FacadeLocator.getService(FuncionarioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		falta = new Falta();
		falta.setFuncionario(new Funcionario());
	}

	public Falta getFalta() {
		return falta;
	}

	public void setFalta(Falta falta) {
		this.falta = falta;
	}

	public List<Falta> getFaltas() {
		if(faltas == null){
			try {
				faltas = facade.listar();
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
				faltas = new ArrayList<Falta>();
			}
		}
		return faltas;
	}
	
	public List<TipoFalta> getTiposFalta(){
		return TipoFalta.getAsList();
	}

	public void inserir(){
		try {
			facade.inserir(falta);
			JSFUtil.addInfoMessage("Ferias adicionada com sucesso!");
			falta = new Falta();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Falta falta){
		try {
			facade.alterar(falta);
			JSFUtil.addInfoMessage("Ferias atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(falta);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição da falta " + ((Falta)event.getObject())+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Falta)event.getObject());
    }  

    public List<Funcionario> completaFuncionario(String query){
    	try {
    		return funcionarioFacade.listarFuncionarioPorNome(query);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
			e.printStackTrace();
		}
    	return new ArrayList<Funcionario>();
    }
}
