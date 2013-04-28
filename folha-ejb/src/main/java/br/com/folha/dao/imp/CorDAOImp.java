package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CorDAO;
import br.com.folha.entity.Cor;

@Stateless(name="CorDAO")
public class CorDAOImp extends GenericDAOImp<Cor> implements CorDAO {

	public CorDAOImp() { 
		super(Cor.class);
	}

}
