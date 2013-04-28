package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.NacionalidadeDAO;
import br.com.folha.entity.Nacionalidade;

@Stateless(name="NacionalidadeDAO")
public class NacionalidadeDAOImp extends GenericDAOImp<Nacionalidade> implements NacionalidadeDAO {

	public NacionalidadeDAOImp() {
		super(Nacionalidade.class);
	}
}
