package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CondicaoDependenteDAO;
import br.com.folha.entity.CondicaoDependente;

@Stateless(name="CondicaoDependenteDAO")
public class CondicaoDependenteDAOImp extends GenericDAOImp<CondicaoDependente> implements CondicaoDependenteDAO {

	public CondicaoDependenteDAOImp() { 
		super(CondicaoDependente.class);
	}

}
