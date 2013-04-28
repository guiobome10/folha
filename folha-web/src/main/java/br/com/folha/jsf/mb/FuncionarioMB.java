package br.com.folha.jsf.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.FileUploadEvent;

import br.com.folha.datamodel.FuncionarioDataModel;
import br.com.folha.entity.Cargo;
import br.com.folha.entity.Cidade;
import br.com.folha.entity.Departamento;
import br.com.folha.entity.Estado;
import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CargoFacade;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.facade.DepartamentoFacade;
import br.com.folha.facade.FuncionarioFacade;
import br.com.folha.jsf.util.JSFUtil;
import br.com.folha.utils.FacadeLocator;

@ManagedBean
@ViewScoped
public class FuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1423012253223570820L;

	private Funcionario funcionario;
	private FuncionarioDataModel funcionarios;
	private Estado estado;
	private Estado estadoNascimento;
	private List<Cidade> cidades;
	private List<Cidade> cidadesNascimento;
	private Departamento departamento;
	private List<Cargo> cargos;
	private List<Departamento> departamentos;

	private FuncionarioFacade facade;
	private CidadeFacade cidadeFacade;
	private DepartamentoFacade departamentoFacade;
	private CargoFacade cargoFacade;
	
	public FuncionarioMB(){
		try {
			facade = FacadeLocator.getService(FuncionarioFacade.class);
			cidadeFacade = FacadeLocator.getService(CidadeFacade.class);
			cargoFacade = FacadeLocator.getService(CargoFacade.class);
			departamentoFacade = FacadeLocator.getService(DepartamentoFacade.class);
		} catch (Exception e) {
			JSFUtil.trataAppExeption(e);
		}
		funcionario = new Funcionario();
		funcionarios = new FuncionarioDataModel();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioDataModel getFuncionarios() {
		return funcionarios;
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

	public Estado getEstadoNascimento() {
		return estadoNascimento;
	}

	public void setEstadoNascimento(Estado estadoNascimento) {
		this.estadoNascimento = estadoNascimento;
	}

	public List<Cidade> getCidadesNascimento() {
		return cidadesNascimento;
	}

	public void setCidadesNascimento(List<Cidade> cidadesNascimento) {
		this.cidadesNascimento = cidadesNascimento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

	@PostConstruct
	private void listar() {
		try {
			departamentos = departamentoFacade.listar();
			departamento = (departamentos.size() > 0 ? departamentos.get(0) : new Departamento());
			cargos = (departamentos.size() > 0 ?  cargoFacade.listarCargosPorDepartamento(departamentos.get(0)) : new ArrayList<Cargo>());
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void inserir(){
		try {
			facade.inserir(funcionario);
			JSFUtil.addInfoMessage("Funcionario adicionado com sucesso!");
			funcionario = new Funcionario();
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void alterar(Funcionario funcionario){
		try {
			facade.alterar(funcionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}
	}
	
	public void salvar(){
		if(funcionario != null ){
			if(funcionario.getId() != null){
				try {
					facade.alterar(funcionario);
					JSFUtil.addInfoMessage("Funcionario atualizado com sucesso!");
					funcionario = new Funcionario();
				} catch (AppException e) {
					JSFUtil.trataAppExeption(e);
				}
			}	
			else{
				try {
					facade.inserir(funcionario);
					JSFUtil.addInfoMessage("Funcionario adicionado com sucesso!");
					funcionario = new Funcionario();
				} catch (AppException e) {
					JSFUtil.trataAppExeption(e);
				}
			}
		}
	}

	public void excluir(){
		try {
			facade.excluir(funcionario);
		} catch (AppException e) {
			JSFUtil.trataAppExeption(e);
		}		
	}

//    public void onCancel(RowEditEvent event) {  
//    	JSFUtil.addInfoMessage("Edição da Funcionario " + ((Funcionario)event.getObject()).getCnpj() + " " + ((Funcionario)event.getObject()).getRazaoSocial() + " foi cancelada");
//    } 
//    
//    public void onEdit(RowEditEvent event) {  
//    	alterar((Funcionario)event.getObject());
//    }  

	public void handleEstadoChange(){
    	if(estado != null ){
    		funcionario.setEstado(estado);
    		try {
				this.cidades = cidadeFacade.listarCidadePorEstado(funcionario.getEstado());
				funcionario.setCidade(cidades.size() > 0 ? cidades.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
    	}else{
    		funcionario.setEstado(estado);
    		cidades = new ArrayList<Cidade>();
    	}
    }

	public void handleEstadoNascimentoChange(){
		if(estadoNascimento != null ){
			funcionario.setEstadoNascimento(estadoNascimento);
			try {
				this.cidadesNascimento = cidadeFacade.listarCidadePorEstado(funcionario.getEstadoNascimento());
				funcionario.setCidadeNascimento(cidadesNascimento.size() > 0 ? cidadesNascimento.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}else{
			funcionario.setEstadoNascimento(estadoNascimento);
			cidadesNascimento = new ArrayList<Cidade>();
		}
	}
	
    public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        funcionario.setFoto(event.getFile().getContents());
    } 

	public void handleDepartamentoChange(){
		if(departamento != null ){
			try {
				this.cargos = cargoFacade.listarCargosPorDepartamento(departamento);
				funcionario.setCargo(cargos.size() > 0 ? cargos.get(0) : null);
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
		}else{
			cargos = new ArrayList<Cargo>();
		}
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public void cancelarAlteracao(){
		this.funcionario = new Funcionario();
	}
	
	public void trataCloseDialog(CloseEvent event){
		this.funcionario = new Funcionario();
	}
	
	public void populaDadosTela(){
		if(funcionario != null){
			try {
				this.cidades = cidadeFacade.listarCidadePorEstado(funcionario.getEstado());
				estado = funcionario.getEstado();
				this.cidadesNascimento = cidadeFacade.listarCidadePorEstado(funcionario.getEstadoNascimento());
				estadoNascimento = funcionario.getEstadoNascimento();
				this.cargos = cargoFacade.listarCargosPorDepartamento(funcionario.getCargo().getDepartamento());
				departamento = funcionario.getCargo().getDepartamento();
			} catch (AppException e) {
				JSFUtil.trataAppExeption(e);
			}
			System.out.println("Funcionario populado");
		}
	}
}
