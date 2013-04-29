package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.NaturezaEmpresaDAO;
import br.com.folha.entity.NaturezaEmpresa;

@Stateless(name="NaturezaEmpresaDAO")
public class NaturezaEmpresaDAOImp extends GenericDAOImp<NaturezaEmpresa> implements NaturezaEmpresaDAO {

	public NaturezaEmpresaDAOImp() {
		super(NaturezaEmpresa.class);
	}

}
