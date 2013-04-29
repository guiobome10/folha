package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Afastamento;
import br.com.folha.exception.AppException;

@Local
public interface AfastamentoFacade {

	public abstract Afastamento inserir(Afastamento afastamento) throws AppException;
	
	public abstract Afastamento alterar(Afastamento afastamento) throws AppException;

	public abstract void excluir(Afastamento afastamento) throws AppException;
	
	public abstract List<Afastamento> listar() throws AppException;
	
	public abstract Afastamento consultar(Long id) throws AppException;

}
