package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.TipoEquipamentoDAO;
import br.com.folha.entity.TipoEquipamento;

@Stateless(name="TipoEquipamentoDAO")
public class TipoEquipamentoDAOImp extends GenericDAOImp<TipoEquipamento> implements TipoEquipamentoDAO {

	public TipoEquipamentoDAOImp() {
		super(TipoEquipamento.class);
	}

}
