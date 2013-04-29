package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.BancoDAO;
import br.com.folha.entity.Banco;

@Stateless(name="BancoDAO")
public class BancoDAOImp extends GenericDAOImp<Banco> implements BancoDAO {

	public BancoDAOImp() { 
		super(Banco.class);
	}

}
