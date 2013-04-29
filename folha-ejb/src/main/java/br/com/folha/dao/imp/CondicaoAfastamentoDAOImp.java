package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CondicaoAfastamentoDAO;
import br.com.folha.entity.CondicaoAfastamento;

@Stateless(name="CondicaoAfastamentoDAO")
public class CondicaoAfastamentoDAOImp extends GenericDAOImp<CondicaoAfastamento> implements CondicaoAfastamentoDAO {

	public CondicaoAfastamentoDAOImp() { 
		super(CondicaoAfastamento.class);
	}

}
