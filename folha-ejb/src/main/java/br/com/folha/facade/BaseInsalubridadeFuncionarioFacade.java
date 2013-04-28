package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.BaseInsalubridadeFuncionario;
import br.com.folha.exception.AppException;

@Local
public interface BaseInsalubridadeFuncionarioFacade {

	public abstract BaseInsalubridadeFuncionario inserir(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException;
	
	public abstract BaseInsalubridadeFuncionario alterar(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException;

	public abstract void excluir(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException;
	
	public abstract List<BaseInsalubridadeFuncionario> listar() throws AppException;
	
	public abstract BaseInsalubridadeFuncionario consultar(Long id) throws AppException;

}
