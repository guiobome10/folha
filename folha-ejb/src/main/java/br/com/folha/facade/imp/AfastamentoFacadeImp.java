package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.AfastamentoDAO;
import br.com.folha.entity.Afastamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.AfastamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="AfastamentoFacade")
public class AfastamentoFacadeImp implements AfastamentoFacade {

	@EJB
	private AfastamentoDAO dao;
	
	@Override
	public Afastamento inserir(Afastamento afastamento) throws AppException {
		TrataErro.trataParametroNull(afastamento, TipoOperacao.INSERCAO);
		return dao.inserir(afastamento);
	}
	
	@Override
	public Afastamento alterar(Afastamento afastamento) throws AppException {
		TrataErro.trataParametroNull(afastamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(afastamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(afastamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(afastamento);
	}
	
	@Override
	public void excluir(Afastamento afastamento) throws AppException {
		TrataErro.trataParametroNull(afastamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(afastamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(afastamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(afastamento);
	}

	@Override
	public List<Afastamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Afastamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
		
}
