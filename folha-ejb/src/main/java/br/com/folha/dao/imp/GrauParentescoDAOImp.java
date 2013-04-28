package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.GrauParentescoDAO;
import br.com.folha.entity.GrauParentesco;

@Stateless(name="GrauParentescoDAO")
public class GrauParentescoDAOImp extends GenericDAOImp<GrauParentesco> implements GrauParentescoDAO {

	public GrauParentescoDAOImp() {
		super(GrauParentesco.class);
	}
}
