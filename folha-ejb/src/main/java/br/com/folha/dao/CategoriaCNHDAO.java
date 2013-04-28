package br.com.folha.dao;

import javax.ejb.Local;

import br.com.folha.entity.CategoriaCNH;

@Local
public interface CategoriaCNHDAO extends GenericDAO<CategoriaCNH> {
	
	public CategoriaCNH consultarPorSigla(String sigla);
}
