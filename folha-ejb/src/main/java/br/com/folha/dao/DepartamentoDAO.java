package br.com.folha.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Departamento;
import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;

@Local
public interface DepartamentoDAO extends GenericDAO<Departamento> {
	
	public List<Departamento> listarDepartamentosPorSindicato(Sindicato sindicato) throws AppException;
}
