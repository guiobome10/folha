package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoJornadaDAO;
import br.com.folha.entity.TipoJornada;

@Stateless(name="TipoJornadaDAO")
public class TipoJornadaDAOImp extends GenericDAOImp<TipoJornada> implements TipoJornadaDAO {

	public TipoJornadaDAOImp() {
		super(TipoJornada.class);
	}

}
