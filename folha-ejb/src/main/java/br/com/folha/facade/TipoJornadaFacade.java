package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.TipoJornada;
import br.com.folha.exception.AppException;

@Local
public interface TipoJornadaFacade {

	public abstract TipoJornada inserir(TipoJornada tipoJornada) throws AppException;
	
	public abstract TipoJornada alterar(TipoJornada tipoJornada) throws AppException;

	public abstract void excluir(TipoJornada tipoJornada) throws AppException;
	
	public abstract List<TipoJornada> listar() throws AppException;
	
	public abstract TipoJornada consultar(Long id) throws AppException;

}
