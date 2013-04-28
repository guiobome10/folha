package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.RowEditEvent;

import br.com.folha.entity.Beneficio;
import br.com.folha.enuns.InformeRendimento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BeneficioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@RequestScoped
public class BeneficioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Beneficio beneficio;
	private List<Beneficio> beneficios;

	private BeneficioFacade facade;
	
	public BeneficioMB(){
		try {
			facade = FacadeLocator.getService(BeneficioFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		beneficio = new Beneficio();
		listar();
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	private void listar() {
		try {
			beneficios = facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(beneficio);
			JSFUtil.addInfoMessage("Beneficio adicionado com sucesso!");
			beneficio = new Beneficio();
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
	public void alterar(Beneficio beneficio){
		try {
			facade.alterar(beneficio);
			JSFUtil.addInfoMessage("Beneficio atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(beneficio);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do beneficio " + ((Beneficio)event.getObject()).getDescricao()+ " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Beneficio)event.getObject());
    }  

    public void handlePercentualChangeListener(ValueChangeEvent e){
    	JSFUtil.addInfoMessage("Valor do campo percentual alterado.");
    }

    public void handleValorChangeListener(ValueChangeEvent e){
    	JSFUtil.addInfoMessage("Valor do campo valor alterado.");
    }
}
