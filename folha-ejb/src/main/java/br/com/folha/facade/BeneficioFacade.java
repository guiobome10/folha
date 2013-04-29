package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Beneficio;
import br.com.folha.exception.AppException;

@Local
public interface BeneficioFacade {

	public abstract Beneficio inserir(Beneficio beneficio) throws AppException;
	
	public abstract Beneficio alterar(Beneficio beneficio) throws AppException;

	public abstract void excluir(Beneficio beneficio) throws AppException;
	
	public abstract List<Beneficio> listar() throws AppException;
	
	public abstract Beneficio consultar(Long id) throws AppException;

}
