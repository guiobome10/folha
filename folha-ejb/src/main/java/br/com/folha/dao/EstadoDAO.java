package br.com.folha.dao;

import javax.ejb.Local;

import br.com.folha.entity.Estado;
import br.com.folha.exception.AppException;

@Local
public interface EstadoDAO extends GenericDAO<Estado> {
	
	public Estado getBySigla(String sigla) throws AppException;
}
