package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CondicaoDependente;
import br.com.folha.exception.AppException;

@Local
public interface CondicaoDependenteFacade {

	public abstract CondicaoDependente inserir(CondicaoDependente condicaoDependente) throws AppException;
	
	public abstract CondicaoDependente alterar(CondicaoDependente condicaoDependente) throws AppException;

	public abstract void excluir(CondicaoDependente condicaoDependente) throws AppException;
	
	public abstract List<CondicaoDependente> listar() throws AppException;
	
	public abstract CondicaoDependente consultar(Long id) throws AppException;

}
