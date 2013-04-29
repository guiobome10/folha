package br.com.folha.dao;

import javax.ejb.Local;

import br.com.folha.entity.Empresa;

@Local
public interface EmpresaDAO extends GenericDAO<Empresa> {
}
