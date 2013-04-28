package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.EquipamentoDAO;
import br.com.folha.entity.Equipamento;

@Stateless(name="EquipamentoDAO")
public class EquipamentoDAOImp extends GenericDAOImp<Equipamento> implements EquipamentoDAO {

	public EquipamentoDAOImp() {
		super(Equipamento.class);
	}

}
