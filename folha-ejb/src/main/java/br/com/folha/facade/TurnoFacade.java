package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Turno;
import br.com.folha.exception.AppException;

@Local
public interface TurnoFacade {

	public abstract Turno inserir(Turno turno) throws AppException;
	
	public abstract Turno alterar(Turno turno) throws AppException;

	public abstract void excluir(Turno turno) throws AppException;
	
	public abstract List<Turno> listar() throws AppException;
	
	public abstract Turno consultar(Long id) throws AppException;

}
