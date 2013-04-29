package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.ProventoDAO;
import br.com.folha.entity.Provento;

@Stateless(name="ProventoDAO")
public class ProventoDAOImp extends GenericDAOImp<Provento> implements ProventoDAO {

	public ProventoDAOImp() {
		super(Provento.class);
	}
}
