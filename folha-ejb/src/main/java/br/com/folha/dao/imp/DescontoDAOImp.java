package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.DescontoDAO;
import br.com.folha.entity.Desconto;

@Stateless(name="DescontoDAO")
public class DescontoDAOImp extends GenericDAOImp<Desconto> implements DescontoDAO {

	public DescontoDAOImp() {
		super(Desconto.class);
	}
}
