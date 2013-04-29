package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.ProventoDAO;
import br.com.folha.entity.Provento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.ProventoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="ProventoFacade")
public class ProventoFacadeImp implements ProventoFacade {

	@EJB
	private ProventoDAO dao;
	
	@Override
	public Provento inserir(Provento provento) throws AppException {
		TrataErro.trataParametroNull(provento, TipoOperacao.INSERCAO);
		return dao.inserir(provento);
	}
	
	@Override
	public Provento alterar(Provento provento) throws AppException {
		TrataErro.trataParametroNull(provento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(provento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(provento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(provento);
	}
	
	@Override
	public void excluir(Provento provento) throws AppException {
		TrataErro.trataParametroNull(provento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(provento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(provento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(provento);
	}

	@Override
	public List<Provento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Provento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
