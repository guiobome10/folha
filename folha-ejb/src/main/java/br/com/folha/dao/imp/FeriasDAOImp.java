package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.FeriasDAO;
import br.com.folha.entity.Ferias;

@Stateless(name="FeriasDAO")
public class FeriasDAOImp extends GenericDAOImp<Ferias> implements FeriasDAO {

	public FeriasDAOImp() {
		super(Ferias.class);
	}
}
