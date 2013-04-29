package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Cidade;
import br.com.folha.entity.Estado;
import br.com.folha.exception.AppException;

@Local
public interface CidadeFacade {

	public abstract Cidade inserir(Cidade cidade) throws AppException;
	
	public abstract Cidade alterar(Cidade cidade) throws AppException;

	public abstract void excluir(Cidade cidade) throws AppException;
	
	public abstract List<Cidade> listar() throws AppException;
	
	public abstract Cidade consultar(Long id) throws AppException;

	public abstract List<Cidade> listarCidadePorEstado(Estado estado) throws AppException;
	
}
