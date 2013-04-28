package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CausaAfastamentoDAO;
import br.com.folha.entity.CausaAfastamento;

@Stateless(name="CausaAfastamentoDAO")
public class CausaAfastamentoDAOImp extends GenericDAOImp<CausaAfastamento> implements CausaAfastamentoDAO {

	public CausaAfastamentoDAOImp() { 
		super(CausaAfastamento.class);
	}

}
