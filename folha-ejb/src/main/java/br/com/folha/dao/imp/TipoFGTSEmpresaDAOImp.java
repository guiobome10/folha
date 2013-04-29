package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoFGTSEmpresaDAO;
import br.com.folha.entity.TipoFGTSEmpresa;

@Stateless(name="TipoFGTSEmpresaDAO")
public class TipoFGTSEmpresaDAOImp extends GenericDAOImp<TipoFGTSEmpresa> implements TipoFGTSEmpresaDAO {

	public TipoFGTSEmpresaDAOImp() {
		super(TipoFGTSEmpresa.class);
	}

}
