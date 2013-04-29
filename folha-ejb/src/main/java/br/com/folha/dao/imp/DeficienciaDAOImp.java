package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.DeficienciaDAO;
import br.com.folha.entity.Deficiencia;


@Stateless(name="DeficienciaDAO")
public class DeficienciaDAOImp extends GenericDAOImp<Deficiencia> implements DeficienciaDAO {

	public DeficienciaDAOImp() {
		super(Deficiencia.class);
	}
}
