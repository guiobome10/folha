package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.BaseInsalubridadeFuncionarioDAO;
import br.com.folha.entity.BaseInsalubridadeFuncionario;

@Stateless(name="BaseInsalubridadeFuncionarioDAO")
public class BaseInsalubridadeFuncionarioDAOImp extends GenericDAOImp<BaseInsalubridadeFuncionario> implements BaseInsalubridadeFuncionarioDAO {

	public BaseInsalubridadeFuncionarioDAOImp() { 
		super(BaseInsalubridadeFuncionario.class);
	}

}
