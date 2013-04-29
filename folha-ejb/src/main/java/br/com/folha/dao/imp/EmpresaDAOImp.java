package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.EmpresaDAO;
import br.com.folha.entity.Empresa;

@Stateless(name="EmpresaDAO")
public class EmpresaDAOImp extends GenericDAOImp<Empresa> implements EmpresaDAO {

	public EmpresaDAOImp() {
		super(Empresa.class);
	}

}
