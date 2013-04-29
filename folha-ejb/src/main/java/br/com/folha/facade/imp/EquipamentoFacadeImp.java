package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.EquipamentoDAO;
import br.com.folha.entity.Equipamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EquipamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="EquipamentoFacade")
public class EquipamentoFacadeImp implements EquipamentoFacade {

	@EJB
	private EquipamentoDAO dao;
	
	@Override
	public Equipamento inserir(Equipamento equipamento) throws AppException {
		TrataErro.trataParametroNull(equipamento, TipoOperacao.INSERCAO);
		return dao.inserir(equipamento);
	}
	
	@Override
	public Equipamento alterar(Equipamento equipamento) throws AppException {
		TrataErro.trataParametroNull(equipamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(equipamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(equipamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(equipamento);
	}
	
	@Override
	public void excluir(Equipamento equipamento) throws AppException {
		TrataErro.trataParametroNull(equipamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(equipamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(equipamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(equipamento);
	}

	@Override
	public List<Equipamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Equipamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
