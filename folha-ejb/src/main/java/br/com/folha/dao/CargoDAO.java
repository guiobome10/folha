package br.com.folha.dao;

import java.util.List;

import javax.ejb.Local;

import br.com.folha.entity.Cargo;
import br.com.folha.entity.Departamento;

@Local
public interface CargoDAO extends GenericDAO<Cargo> {

	List<Cargo> listarCargosPorDepartamento(Departamento departamento);
}
