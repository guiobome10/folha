package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Desconto;
import br.com.folha.enuns.InformeRendimento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DescontoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class DescontoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Desconto desconto;
	private List<Desconto> descontos;

	private DescontoFacade facade;
	
	public DescontoMB(){
		try {
			facade = FacadeLocator.getService(DescontoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		desconto = new Desconto();
		listar();
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	private void listar() {
		try {
			descontos = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(desconto);
			JSFUtil.addInfoMessage("Desconto adicionado com sucesso!");
			desconto = new Desconto();
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
	public void alterar(Desconto desconto){
		try {
			facade.alterar(desconto);
			JSFUtil.addInfoMessage("Desconto atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(desconto);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do desconto " + ((Desconto)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Desconto)event.getObject());
    }  

}
