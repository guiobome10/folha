package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CondicaoAfastamento;
import br.com.folha.exception.AppException;

@Local
public interface CondicaoAfastamentoFacade {

	public abstract CondicaoAfastamento inserir(CondicaoAfastamento condicaoAfastamento) throws AppException;
	
	public abstract CondicaoAfastamento alterar(CondicaoAfastamento condicaoAfastamento) throws AppException;

	public abstract void excluir(CondicaoAfastamento condicaoAfastamento) throws AppException;
	
	public abstract List<CondicaoAfastamento> listar() throws AppException;
	
	public abstract CondicaoAfastamento consultar(Long id) throws AppException;

}
