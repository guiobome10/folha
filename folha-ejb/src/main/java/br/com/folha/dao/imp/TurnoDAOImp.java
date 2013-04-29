package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TurnoDAO;
import br.com.folha.entity.Turno;

@Stateless(name="TurnoDAO")
public class TurnoDAOImp extends GenericDAOImp<Turno> implements TurnoDAO {

	public TurnoDAOImp() {
		super(Turno.class);
	}

}
