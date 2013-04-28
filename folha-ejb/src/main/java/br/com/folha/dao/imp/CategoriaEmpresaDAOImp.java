package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CategoriaEmpresaDAO;
import br.com.folha.entity.CategoriaEmpresa;

@Stateless(name="CategoriaEmpresaDAO")
public class CategoriaEmpresaDAOImp extends GenericDAOImp<CategoriaEmpresa> implements CategoriaEmpresaDAO {

	public CategoriaEmpresaDAOImp() {
		super(CategoriaEmpresa.class);
	}

}
