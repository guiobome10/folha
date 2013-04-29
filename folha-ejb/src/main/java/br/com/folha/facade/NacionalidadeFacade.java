package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Nacionalidade;
import br.com.folha.exception.AppException;

@Local
public interface NacionalidadeFacade {

	public abstract Nacionalidade inserir(Nacionalidade nacionalidade) throws AppException;
	
	public abstract Nacionalidade alterar(Nacionalidade nacionalidade) throws AppException;

	public abstract void excluir(Nacionalidade nacionalidade) throws AppException;
	
	public abstract List<Nacionalidade> listar() throws AppException;
	
	public abstract Nacionalidade consultar(Long id) throws AppException;

}
