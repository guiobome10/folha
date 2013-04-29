package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Banco;
import br.com.folha.exception.AppException;

@Local
public interface BancoFacade {

	public abstract Banco inserir(Banco banco) throws AppException;
	
	public abstract Banco alterar(Banco banco) throws AppException;

	public abstract void excluir(Banco banco) throws AppException;
	
	public abstract List<Banco> listar() throws AppException;
	
	public abstract Banco consultar(Long id) throws AppException;

}
