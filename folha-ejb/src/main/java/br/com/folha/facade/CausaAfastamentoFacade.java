package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CausaAfastamento;
import br.com.folha.exception.AppException;

@Local
public interface CausaAfastamentoFacade {

	public abstract CausaAfastamento inserir(CausaAfastamento causaAfastamento) throws AppException;
	
	public abstract CausaAfastamento alterar(CausaAfastamento causaAfastamento) throws AppException;

	public abstract void excluir(CausaAfastamento causaAfastamento) throws AppException;
	
	public abstract List<CausaAfastamento> listar() throws AppException;
	
	public abstract CausaAfastamento consultar(Long id) throws AppException;

}
