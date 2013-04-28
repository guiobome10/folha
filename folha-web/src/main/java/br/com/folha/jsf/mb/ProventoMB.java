package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Provento;
import br.com.folha.enuns.InformeRendimento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.ProventoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class ProventoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Provento provento;
	private List<Provento> proventos;

	private ProventoFacade facade;
	
	public ProventoMB(){
		try {
			facade = FacadeLocator.getService(ProventoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		provento = new Provento();
		listar();
	}

	public Provento getProvento() {
		return provento;
	}

	public void setProvento(Provento provento) {
		this.provento = provento;
	}

	public List<Provento> getProventos() {
		return proventos;
	}

	public void setProventos(List<Provento> proventos) {
		this.proventos = proventos;
	}

	private void listar() {
		try {
			proventos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(provento);
			JSFUtil.addInfoMessage("Provento adicionado com sucesso!");
			provento = new Provento();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public List<SelectItem> getInformesRendimento(){
		InformeRendimento[] inf = InformeRendimento.values();
		List<SelectItem> list = new ArrayList<SelectItem>();
		for(int i = 0; i < inf.length; i++){
			list.add(new SelectItem(inf[i], inf[i].getValor()));
		}
		return list;
	}
	public void alterar(Provento provento){
		try {
			facade.alterar(provento);
			JSFUtil.addInfoMessage("Provento atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(provento);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do provento " + ((Provento)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Provento)event.getObject());
    }  

}
