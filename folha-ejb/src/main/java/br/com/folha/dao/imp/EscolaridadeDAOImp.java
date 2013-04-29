package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.EscolaridadeDAO;
import br.com.folha.entity.Escolaridade;

@Stateless(name="EscolaridadeDAO")
public class EscolaridadeDAOImp extends GenericDAOImp<Escolaridade> implements EscolaridadeDAO {

	public EscolaridadeDAOImp() {
		super(Escolaridade.class);
	}

}
