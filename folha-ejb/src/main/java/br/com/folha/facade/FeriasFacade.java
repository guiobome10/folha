package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Ferias;
import br.com.folha.exception.AppException;

@Local
public interface FeriasFacade {

	public abstract Ferias inserir(Ferias ferias) throws AppException;
	
	public abstract Ferias alterar(Ferias ferias) throws AppException;

	public abstract void excluir(Ferias ferias) throws AppException;
	
	public abstract List<Ferias> listar() throws AppException;
	
	public abstract Ferias consultar(Long id) throws AppException;

}
