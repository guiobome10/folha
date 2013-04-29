package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Departamento;
import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;

@Local
public interface DepartamentoFacade {

	public abstract Departamento inserir(Departamento departamento) throws AppException;
	
	public abstract Departamento alterar(Departamento departamento) throws AppException;

	public abstract void excluir(Departamento departamento) throws AppException;
	
	public abstract List<Departamento> listar() throws AppException;
	
	public abstract Departamento consultar(Long id) throws AppException;

	public abstract List<Departamento> listarDepartamentosPorSindicato(Sindicato sindicato) throws AppException;

}
