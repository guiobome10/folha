package br.com.folha.facade;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.primefaces.model.SortOrder;

import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;

@Local
public interface FuncionarioFacade {

	Funcionario inserir(Funcionario funcionario) throws AppException;
	
	Funcionario alterar(Funcionario funcionario) throws AppException;

	void excluir(Funcionario funcionario) throws AppException;
	
	List<Funcionario> listarFuncionarioPorNome(String nome) throws AppException;
	
	List<Funcionario> listar() throws AppException;
	
	List<Funcionario> listarLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao, SortOrder ordenacao, Map<String, String> filtros) throws AppException;
	
	Long listarLazyCount() throws AppException;
	
	Funcionario consultar(Long id) throws AppException;

}
