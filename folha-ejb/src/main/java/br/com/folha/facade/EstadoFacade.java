package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Estado;
import br.com.folha.exception.AppException;

@Local
public interface EstadoFacade {

	public abstract Estado inserir(Estado estado) throws AppException;
	
	public abstract Estado alterar(Estado estado) throws AppException;

	public abstract void excluir(Estado estado) throws AppException;
	
	public abstract List<Estado> listar() throws AppException;
	
	public abstract Estado consultar(String sigla) throws AppException;

}
