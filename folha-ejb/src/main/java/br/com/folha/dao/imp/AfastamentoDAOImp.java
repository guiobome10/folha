package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.AfastamentoDAO;
import br.com.folha.entity.Afastamento;

@Stateless(name="AfastamentoDAO")
public class AfastamentoDAOImp extends GenericDAOImp<Afastamento> implements AfastamentoDAO {

	public AfastamentoDAOImp() { 
		super(Afastamento.class);
	}

}
