package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Dependente;
import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;

@Local
public interface DependenteFacade {

	public abstract Dependente inserir(Dependente dependente) throws AppException;
	
	public abstract Dependente alterar(Dependente dependente) throws AppException;

	public abstract void excluir(Dependente dependente) throws AppException;
	
	public abstract List<Dependente> listar() throws AppException;
	
	public abstract Dependente consultar(Long id) throws AppException;

	List<Dependente> listarPorFuncionario(Funcionario funcionario) throws AppException;

}
