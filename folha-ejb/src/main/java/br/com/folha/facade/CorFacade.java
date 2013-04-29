package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Cor;
import br.com.folha.exception.AppException;

@Local
public interface CorFacade {

	public abstract Cor inserir(Cor cor) throws AppException;
	
	public abstract Cor alterar(Cor cor) throws AppException;

	public abstract void excluir(Cor cor) throws AppException;
	
	public abstract List<Cor> listar() throws AppException;
	
	public abstract Cor consultar(Long id) throws AppException;

}
