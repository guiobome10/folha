package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CategoriaEmpresa;
import br.com.folha.exception.AppException;

@Local
public interface CategoriaEmpresaFacade {

	public abstract CategoriaEmpresa inserir(CategoriaEmpresa categoriaEmpresa) throws AppException;
	
	public abstract CategoriaEmpresa alterar(CategoriaEmpresa categoriaEmpresa) throws AppException;

	public abstract void excluir(CategoriaEmpresa categoriaEmpresa) throws AppException;
	
	public abstract List<CategoriaEmpresa> listar() throws AppException;
	
	public abstract CategoriaEmpresa consultar(Long id) throws AppException;

}
