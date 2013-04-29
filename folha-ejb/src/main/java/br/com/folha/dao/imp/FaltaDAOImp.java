package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.FaltaDAO;
import br.com.folha.entity.Falta;

@Stateless(name="FaltaDAO")
public class FaltaDAOImp extends GenericDAOImp<Falta> implements FaltaDAO {

	public FaltaDAOImp() {
		super(Falta.class);
	}
}
