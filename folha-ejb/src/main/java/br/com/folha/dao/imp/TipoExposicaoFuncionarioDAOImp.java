package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoExposicaoFuncionarioDAO;
import br.com.folha.entity.TipoExposicaoFuncionario;

@Stateless(name="TipoExposicaoFuncionarioDAO")
public class TipoExposicaoFuncionarioDAOImp extends GenericDAOImp<TipoExposicaoFuncionario> implements TipoExposicaoFuncionarioDAO {

	public TipoExposicaoFuncionarioDAOImp() {
		super(TipoExposicaoFuncionario.class);
	}

}
