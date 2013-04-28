package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CategoriaCNH;
import br.com.folha.exception.AppException;

@Local
public interface CategoriaCNHFacade {

	public abstract CategoriaCNH inserir(CategoriaCNH categoriaCNH) throws AppException;
	
	public abstract CategoriaCNH alterar(CategoriaCNH categoriaCNH) throws AppException;

	public abstract void excluir(CategoriaCNH categoriaCNH) throws AppException;
	
	public abstract List<CategoriaCNH> listar() throws AppException;
	
	public abstract CategoriaCNH consultar(Long id) throws AppException;

}
