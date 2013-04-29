package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoRaisFuncionario;
import br.com.folha.exception.AppException;

@Local
public interface TipoRaisFuncionarioFacade {

	public abstract TipoRaisFuncionario inserir(TipoRaisFuncionario tipoRaisFuncionario) throws AppException;
	
	public abstract TipoRaisFuncionario alterar(TipoRaisFuncionario tipoRaisFuncionario) throws AppException;

	public abstract void excluir(TipoRaisFuncionario tipoRaisFuncionario) throws AppException;
	
	public abstract List<TipoRaisFuncionario> listar() throws AppException;
	
	public abstract TipoRaisFuncionario consultar(Long id) throws AppException;

}
