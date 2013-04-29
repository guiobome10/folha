package br.com.folha.dao;

import javax.ejb.Local;

import br.com.folha.entity.Banco;

@Local
public interface BancoDAO extends GenericDAO<Banco> {
}
