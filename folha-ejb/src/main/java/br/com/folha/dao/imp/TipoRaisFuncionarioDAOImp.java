package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoRaisFuncionarioDAO;
import br.com.folha.entity.TipoRaisFuncionario;

@Stateless(name="TipoRaisFuncionarioDAO")
public class TipoRaisFuncionarioDAOImp extends GenericDAOImp<TipoRaisFuncionario> implements TipoRaisFuncionarioDAO {

	public TipoRaisFuncionarioDAOImp() {
		super(TipoRaisFuncionario.class);
	}

}
