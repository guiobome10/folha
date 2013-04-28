package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.CategoriaFuncionario;
import br.com.folha.exception.AppException;

@Local
public interface CategoriaFuncionarioFacade {

	public abstract CategoriaFuncionario inserir(CategoriaFuncionario categoriaFuncionario) throws AppException;
	
	public abstract CategoriaFuncionario alterar(CategoriaFuncionario categoriaFuncionario) throws AppException;

	public abstract void excluir(CategoriaFuncionario categoriaFuncionario) throws AppException;
	
	public abstract List<CategoriaFuncionario> listar() throws AppException;
	
	public abstract CategoriaFuncionario consultar(Long id) throws AppException;

}
