package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CondicaoAfastamentoDAO;
import br.com.folha.entity.CondicaoAfastamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CondicaoAfastamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CondicaoAfastamentoFacade")
public class CondicaoAfastamentoFacadeImp implements CondicaoAfastamentoFacade {

	@EJB
	private CondicaoAfastamentoDAO dao;
	
	@Override
	public CondicaoAfastamento inserir(CondicaoAfastamento condicaoAfastamento) throws AppException {
		TrataErro.trataParametroNull(condicaoAfastamento, TipoOperacao.INSERCAO);
		return dao.inserir(condicaoAfastamento);
	}
	
	@Override
	public CondicaoAfastamento alterar(CondicaoAfastamento condicaoAfastamento) throws AppException {
		TrataErro.trataParametroNull(condicaoAfastamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(condicaoAfastamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(condicaoAfastamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(condicaoAfastamento);
	}
	
	@Override
	public void excluir(CondicaoAfastamento condicaoAfastamento) throws AppException {
		TrataErro.trataParametroNull(condicaoAfastamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(condicaoAfastamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(condicaoAfastamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(condicaoAfastamento);
	}

	@Override
	public List<CondicaoAfastamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CondicaoAfastamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
