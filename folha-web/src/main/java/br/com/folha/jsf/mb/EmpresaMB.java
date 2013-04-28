package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.folha.cnpj.util.ConsultaCnpj;
import br.com.folha.cnpj.util.EmpresaReceita;
import br.com.folha.entity.Cidade;
import br.com.folha.entity.Empresa;
import br.com.folha.entity.Endereco;
import br.com.folha.entity.Estado;
import br.com.folha.enuns.CodigoRecolhimento;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.facade.EmpresaFacade;
import br.com.folha.facade.EnderecoFacade;
import br.com.folha.facade.EstadoFacade;
import br.com.folha.facade.NaturezaEmpresaFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ViewScoped
public class EmpresaMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Empresa empresa;
	private List<Empresa> empresas;
	private List<Cidade> cidades;
	private Estado estado;
	private Estado estadoResponsavel;
	private List<Cidade> cidadesResponsavel;

	private EmpresaFacade facade;
	private NaturezaEmpresaFacade naturezaFacade;
	private CidadeFacade cidadeFacade;
	private EstadoFacade estadoFacade;
	private EnderecoFacade enderecoFacade;

	private ConsultaCnpj consulta;
	private String captcha;
	private String imagePath;
	
	public EmpresaMB(){
		try {
			facade = FacadeLocator.getService(EmpresaFacade.class);
			naturezaFacade = FacadeLocator.getService(NaturezaEmpresaFacade.class);
			cidadeFacade = FacadeLocator.getService(CidadeFacade.class);
			estadoFacade = FacadeLocator.getService(EstadoFacade.class);
			enderecoFacade = FacadeLocator.getService(EnderecoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		empresa = new Empresa();
		empresa.setPercentualAdiantamento(new Double(40));
		inicializa();
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
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Empresa> getEmpresas() {
		if(empresas == null){
			try {
				empresas = facade.listar();
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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

	public void inserir(){
		try {
			facade.inserir(empresa);
			JSFUtil.addInfoMessage("Empresa adicionada com sucesso!");
			empresa = new Empresa();
			inicializa();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Empresa empresa){
		try {
			facade.alterar(empresa);
			JSFUtil.addInfoMessage("Empresa atualizada com sucesso!");
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void excluir(){
		try {
			facade.excluir(empresa);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

//    public void onCancel(RowEditEvent event) {  
//    	JSFUtil.addInfoMessage("Edição da Empresa " + ((Empresa)event.getObject()).getCnpj() + " " + ((Empresa)event.getObject()).getRazaoSocial() + " foi cancelada");
//    } 
//    
//    public void onEdit(RowEditEvent event) {  
//    	alterar((Empresa)event.getObject());
//    }  

    public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void handleEstadoChange(){
    	if(estado != null ){
    		empresa.setEstado(estado);
    		try {
				this.cidades = cidadeFacade.listarCidadePorEstado(empresa.getEstado());
				empresa.setCidade(cidades.size() > 0 ? cidades.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}else{
    		empresa.setEstado(estado);
    		cidades = new ArrayList<Cidade>();
    	}
    }

	public void handleEstadoResponsavelChange(){
		if(estadoResponsavel != null ){
			empresa.setEstadoResponsavel(estadoResponsavel);
			try {
				this.cidadesResponsavel = cidadeFacade.listarCidadePorEstado(empresa.getEstadoResponsavel());
				empresa.setCidadeResponsavel(cidadesResponsavel.size() > 0 ? cidadesResponsavel.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}else{
			empresa.setEstadoResponsavel(estadoResponsavel);
			cidadesResponsavel = new ArrayList<Cidade>();
		}
	}

	public Estado getEstadoResponsavel() {
		return estadoResponsavel;
	}

	public void setEstadoResponsavel(Estado estadoResponsavel) {
		this.estadoResponsavel = estadoResponsavel;
	}

	public List<Cidade> getCidadesResponsavel() {
		return cidadesResponsavel;
	}

	public void setCidadesResponsavel(List<Cidade> cidadesResponsavel) {
		this.cidadesResponsavel = cidadesResponsavel;
	}
	
	public List<CodigoRecolhimento> getCodigosRecolhimento(){
		return CodigoRecolhimento.getAsList();
	}
	public boolean isCeiObrigario(){
		if(empresa.getCodigoRecolhimento() == null)
			return false;
		return empresa.getCodigoRecolhimento().equals(CodigoRecolhimento.COD_150);
	}
	
	public void trataCep(){
		try {
			Endereco endereco = enderecoFacade.consultarCep(empresa.getCep(), JSFUtil.getXmlPath());
			empresa.setBairro(endereco.getBairro());
			empresa.setEndereco(endereco.getTipoLogradouro() + " " + endereco.getLogradouro());
			empresa.setEstado(estadoFacade.consultar(endereco.getUf()));
			estado = empresa.getEstado();
			cidades = cidadeFacade.listarCidadePorEstado(empresa.getEstado());
			for(Cidade cidade : cidades){
				if(cidade.getNome().equalsIgnoreCase(endereco.getCidade())){
					empresa.setCidade(cidade);
				}
			}
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}

	public void trataCepResponsavel(){
		try {
			Endereco endereco = enderecoFacade.consultarCep(empresa.getCepResponsavel(), JSFUtil.getXmlPath());
			empresa.setBairroResponsavel(endereco.getBairro());
			empresa.setEnderecoResponsavel(endereco.getTipoLogradouro() + " " + endereco.getLogradouro());
			empresa.setEstadoResponsavel(estadoFacade.consultar(endereco.getUf()));
			estadoResponsavel = empresa.getEstado();
			cidadesResponsavel = cidadeFacade.listarCidadePorEstado(empresa.getEstadoResponsavel());
			for(Cidade cidade : cidadesResponsavel){
				if(cidade.getNome().equalsIgnoreCase(endereco.getCidade())){
					empresa.setCidadeResponsavel(cidade);
				}
			}
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void consultaCNPJ(){
		try {
			EmpresaReceita empresaRFB = consulta.consultarCnpj(empresa.getCnpj(), captcha);
			empresa.setRazaoSocial(empresaRFB.getNomeEmpresarial());
			empresa.setNaturezaEmpresa(naturezaFacade.consultar(Long.parseLong(empresaRFB.getCodigoNaturezaJuridica())));
			empresa.setCnae(Long.parseLong(empresaRFB.getCodigoAtividadePrincipal()));
			empresa.setNumero(empresaRFB.getNumero());
			empresa.setComplemento(empresaRFB.getComplemento());
			empresa.setCep(empresaRFB.getCep());
			trataCep();
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
			inicializa();
		}

	}
}
