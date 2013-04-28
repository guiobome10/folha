package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;

@Local
public interface SindicatoFacade {

	public abstract Sindicato inserir(Sindicato sindicato) throws AppException;
	
	public abstract Sindicato alterar(Sindicato sindicato) throws AppException;

	public abstract void excluir(Sindicato sindicato) throws AppException;
	
	public abstract List<Sindicato> listar() throws AppException;
	
	public abstract Sindicato consultar(Long id) throws AppException;

}
