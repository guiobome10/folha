package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.SindicatoDAO;
import br.com.folha.entity.Sindicato;

@Stateless(name="SindicatoDAO")
public class SindicatoDAOImp extends GenericDAOImp<Sindicato> implements SindicatoDAO {

	public SindicatoDAOImp() {
		super(Sindicato.class);
	}
}
