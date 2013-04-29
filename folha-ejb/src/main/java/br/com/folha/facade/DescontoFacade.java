package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Desconto;
import br.com.folha.exception.AppException;

@Local
public interface DescontoFacade {

	public abstract Desconto inserir(Desconto desconto) throws AppException;
	
	public abstract Desconto alterar(Desconto desconto) throws AppException;

	public abstract void excluir(Desconto desconto) throws AppException;
	
	public abstract List<Desconto> listar() throws AppException;
	
	public abstract Desconto consultar(Long id) throws AppException;

}
