package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Provento;
import br.com.folha.exception.AppException;

@Local
public interface ProventoFacade {

	public abstract Provento inserir(Provento provento) throws AppException;
	
	public abstract Provento alterar(Provento provento) throws AppException;

	public abstract void excluir(Provento provento) throws AppException;
	
	public abstract List<Provento> listar() throws AppException;
	
	public abstract Provento consultar(Long id) throws AppException;

}
