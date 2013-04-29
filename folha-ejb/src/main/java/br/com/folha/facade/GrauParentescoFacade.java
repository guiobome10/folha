package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.GrauParentesco;
import br.com.folha.exception.AppException;

@Local
public interface GrauParentescoFacade {

	public abstract GrauParentesco inserir(GrauParentesco grauParentesco) throws AppException;
	
	public abstract GrauParentesco alterar(GrauParentesco grauParentesco) throws AppException;

	public abstract void excluir(GrauParentesco grauParentesco) throws AppException;
	
	public abstract List<GrauParentesco> listar() throws AppException;
	
	public abstract GrauParentesco consultar(Long id) throws AppException;

}
