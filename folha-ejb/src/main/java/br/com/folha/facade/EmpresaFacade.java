package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Empresa;
import br.com.folha.exception.AppException;

@Local
public interface EmpresaFacade {

	public abstract Empresa inserir(Empresa empresa) throws AppException;
	
	public abstract Empresa alterar(Empresa empresa) throws AppException;

	public abstract void excluir(Empresa empresa) throws AppException;
	
	public abstract List<Empresa> listar() throws AppException;
	
	public abstract Empresa consultar(Long id) throws AppException;

}
