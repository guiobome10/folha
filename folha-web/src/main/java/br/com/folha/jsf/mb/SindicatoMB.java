package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.folha.cnpj.util.ConsultaCnpj;
import br.com.folha.cnpj.util.EmpresaReceita;
import br.com.folha.entity.Cidade;
import br.com.folha.entity.Endereco;
import br.com.folha.entity.Estado;
import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.facade.EnderecoFacade;
import br.com.folha.facade.EstadoFacade;
import br.com.folha.facade.SindicatoFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ViewScoped
public class SindicatoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Sindicato sindicato;
	private List<Cidade> cidades;
	private Estado estado;
	private SindicatoFacade facade;
	private CidadeFacade cidadeFacade;

	private EnderecoFacade enderecoFacade;
	private EstadoFacade estadoFacade;
	
	private ConsultaCnpj consulta;
	private String captcha;
	private String imagePath;
	
	
	public SindicatoMB(){
		try {
			facade = FacadeLocator.getService(SindicatoFacade.class);
			cidadeFacade = FacadeLocator.getService(CidadeFacade.class);
			estadoFacade = FacadeLocator.getService(EstadoFacade.class);
			enderecoFacade = FacadeLocator.getService(EnderecoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		inicializa();
		sindicato = new  Sindicato();
	}

	public Sindicato getSindicato() {
		return sindicato;
	}

	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}

	public List<Sindicato> getSindicatos() {
		try {
			return facade.listar();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
			return new ArrayList<Sindicato>();
		}
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

    public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void inicializa(){
		try {
			consulta = new ConsultaCnpj();
			captcha = "";
			imagePath = null;
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public ConsultaCnpj getConsulta() {
		return consulta;
	}


	public void setConsulta(ConsultaCnpj consulta) {
		this.consulta = consulta;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getImagePath() {
		if(imagePath == null){
			try {
				imagePath = consulta.getCaptchaPath(FacesContext.getCurrentInstance());
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void consultaCNPJ(){
		try {
			EmpresaReceita empresaRFB = consulta.consultarCnpj(sindicato.getCnpj(), captcha);
			if(empresaRFB.isSindicato()){
				sindicato.setRazaoSocial(empresaRFB.getNomeEmpresarial());
				sindicato.setNumero(empresaRFB.getNumero());
				sindicato.setComplemento(empresaRFB.getComplemento());
				sindicato.setCep(empresaRFB.getCep());
				trataCep();
			} else {
				JSFUtil.addErrorMessage("O cnpj informado não é de sindicato.");
			}
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
			inicializa();
		}

	}

	public void inserir(){
		try {
			facade.inserir(sindicato);
			JSFUtil.addInfoMessage("Sindicato adicionado com sucesso!");
			sindicato = new Sindicato();
			inicializa();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Sindicato sindicato){
		try {
			facade.alterar(sindicato);
			JSFUtil.addInfoMessage("Sindicato atualizado com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(sindicato);
			JSFUtil.addInfoMessage("Sindicato excluído com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

    public void onCancel(RowEditEvent event) {  
    	JSFUtil.addInfoMessage("Edição do sindicato " + ((Sindicato)event.getObject()).getRazaoSocial() + " foi cancelada");
    } 
    
    public void onEdit(RowEditEvent event) {  
    	alterar((Sindicato)event.getObject());
    }  

    @PostConstruct
    public void postConstruct(){
    	if(estado != null){
    		try {
				cidades = cidadeFacade.listarCidadePorEstado(estado);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}else {
    		try {
    			estado = new Estado();
    			sindicato.setEstado(estado);
				cidades = cidadeFacade.listarCidadePorEstado(estado);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}
    }
    
	public void handleEstadoChange(){
    	if(estado != null ){
    		sindicato.setEstado(estado);
    		try {
				this.cidades = cidadeFacade.listarCidadePorEstado(sindicato.getEstado());
				sindicato.setCidade(cidades.size() > 0 ? cidades.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}else{
    		sindicato.setEstado(estado);
    		cidades = new ArrayList<Cidade>();
    	}
    }
    
    	public void trataCep(){
		try {
			Endereco endereco = enderecoFacade.consultarCep(sindicato.getCep(), JSFUtil.getXmlPath());
			sindicato.setBairro(endereco.getBairro());
			sindicato.setEndereco(endereco.getTipoLogradouro() + " " + endereco.getLogradouro());
			sindicato.setEstado(estadoFacade.consultar(endereco.getUf()));
			estado = sindicato.getEstado();
			cidades = cidadeFacade.listarCidadePorEstado(sindicato.getEstado());
			for(Cidade cidade : cidades){
				if(cidade.getNome().equalsIgnoreCase(endereco.getCidade())){
					sindicato.setCidade(cidade);
				}
			}
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
    

}
