package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoEquipamentoDAO;
import br.com.folha.entity.TipoEquipamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoEquipamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoEquipamentoFacade")
public class TipoEquipamentoFacadeImp implements TipoEquipamentoFacade {

	@EJB
	private TipoEquipamentoDAO dao;
	
	@Override
	public TipoEquipamento inserir(TipoEquipamento tipoEquipamento) throws AppException {
		TrataErro.trataParametroNull(tipoEquipamento, TipoOperacao.INSERCAO);
		return dao.inserir(tipoEquipamento);
	}
	
	@Override
	public TipoEquipamento alterar(TipoEquipamento tipoEquipamento) throws AppException {
		TrataErro.trataParametroNull(tipoEquipamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoEquipamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoEquipamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoEquipamento);
	}
	
	@Override
	public void excluir(TipoEquipamento tipoEquipamento) throws AppException {
		TrataErro.trataParametroNull(tipoEquipamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoEquipamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoEquipamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoEquipamento);
	}

	@Override
	public List<TipoEquipamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoEquipamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
