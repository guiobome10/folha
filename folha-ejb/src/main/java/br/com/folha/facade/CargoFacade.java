package br.com.folha.facade;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Cargo;
import br.com.folha.entity.Departamento;
import br.com.folha.exception.AppException;

@Local
public interface CargoFacade {

	public abstract Cargo inserir(Cargo cargo) throws AppException;
	
	public abstract Cargo alterar(Cargo cargo) throws AppException;

	public abstract void excluir(Cargo cargo) throws AppException;
	
	public abstract List<Cargo> listar() throws AppException;
	
	public abstract Cargo consultar(Long id) throws AppException;

	public abstract List<Cargo> listarCargosPorDepartamento(Departamento departamento) throws AppException;

}
