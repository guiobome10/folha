package br.com.folha.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Cidade;
import br.com.folha.entity.Estado;

@Local
public interface CidadeDAO extends GenericDAO<Cidade> {
	
	public List<Cidade> listarCidadesPorEstado(Estado estado);
}
