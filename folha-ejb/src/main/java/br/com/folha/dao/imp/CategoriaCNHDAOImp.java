package br.com.folha.dao.imp;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.folha.dao.CategoriaCNHDAO;
import br.com.folha.entity.CategoriaCNH;

@Stateless(name="CategoriaCNHDAO")
public class CategoriaCNHDAOImp extends GenericDAOImp<CategoriaCNH> implements CategoriaCNHDAO {

	public CategoriaCNHDAOImp() {
		super(CategoriaCNH.class);
	}

	@Override
	public CategoriaCNH consultarPorSigla(String sigla) {
		TypedQuery<CategoriaCNH> query = super.getEntityManager().createNamedQuery(CategoriaCNH.CONSULTAR_POR_SIGLA, CategoriaCNH.class);
        query.setParameter("sigla", sigla);    
		return query.getSingleResult();
	}

}
