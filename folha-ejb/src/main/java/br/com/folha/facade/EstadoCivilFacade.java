package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.EstadoCivil;
import br.com.folha.exception.AppException;

@Local
public interface EstadoCivilFacade {

	public abstract EstadoCivil inserir(EstadoCivil estadoCivil) throws AppException;
	
	public abstract EstadoCivil alterar(EstadoCivil estadoCivil) throws AppException;

	public abstract void excluir(EstadoCivil estadoCivil) throws AppException;
	
	public abstract List<EstadoCivil> listar() throws AppException;
	
	public abstract EstadoCivil consultar(Long id) throws AppException;

}
