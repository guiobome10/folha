package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.EstadoCivilDAO;
import br.com.folha.entity.EstadoCivil;

@Stateless(name="EstadoCivilDAO")
public class EstadoCivilDAOImp extends GenericDAOImp<EstadoCivil> implements EstadoCivilDAO {

	public EstadoCivilDAOImp() {
		super(EstadoCivil.class);
	}

}
