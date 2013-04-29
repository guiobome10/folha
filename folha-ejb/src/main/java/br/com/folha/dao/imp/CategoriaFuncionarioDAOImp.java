package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.CategoriaFuncionarioDAO;
import br.com.folha.entity.CategoriaFuncionario;

@Stateless(name="CategoriaFuncionarioDAO")
public class CategoriaFuncionarioDAOImp extends GenericDAOImp<CategoriaFuncionario> implements CategoriaFuncionarioDAO {

	public CategoriaFuncionarioDAOImp() {
		super(CategoriaFuncionario.class);
	}

}
