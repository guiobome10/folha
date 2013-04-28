package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoExposicaoFuncionario;
import br.com.folha.exception.AppException;

@Local
public interface TipoExposicaoFuncionarioFacade {

	public abstract TipoExposicaoFuncionario inserir(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException;
	
	public abstract TipoExposicaoFuncionario alterar(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException;

	public abstract void excluir(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException;
	
	public abstract List<TipoExposicaoFuncionario> listar() throws AppException;
	
	public abstract TipoExposicaoFuncionario consultar(Long id) throws AppException;

}
