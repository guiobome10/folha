package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoPagamentoFuncionarioDAO;
import br.com.folha.entity.TipoPagamentoFuncionario;

@Stateless(name="TipoPagamentoFuncionarioDAO")
public class TipoPagamentoFuncionarioDAOImp extends GenericDAOImp<TipoPagamentoFuncionario> implements TipoPagamentoFuncionarioDAO {

	public TipoPagamentoFuncionarioDAOImp() {
		super(TipoPagamentoFuncionario.class);
	}

}
