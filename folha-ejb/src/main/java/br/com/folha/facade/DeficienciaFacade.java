package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Deficiencia;
import br.com.folha.exception.AppException;

@Local
public interface DeficienciaFacade {

	public abstract Deficiencia inserir(Deficiencia deficiencia) throws AppException;
	
	public abstract Deficiencia alterar(Deficiencia deficiencia) throws AppException;

	public abstract void excluir(Deficiencia deficiencia) throws AppException;
	
	public abstract List<Deficiencia> listar() throws AppException;
	
	public abstract Deficiencia consultar(Long id) throws AppException;

}
