package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Escolaridade;
import br.com.folha.exception.AppException;

@Local
public interface EscolaridadeFacade {

	public abstract Escolaridade inserir(Escolaridade escolaridade) throws AppException;
	
	public abstract Escolaridade alterar(Escolaridade escolaridade) throws AppException;

	public abstract void excluir(Escolaridade escolaridade) throws AppException;
	
	public abstract List<Escolaridade> listar() throws AppException;
	
	public abstract Escolaridade consultar(Long id) throws AppException;

}
