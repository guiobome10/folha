package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CausaAfastamentoDAO;
import br.com.folha.entity.CausaAfastamento;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CausaAfastamentoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CausaAfastamentoFacade")
public class CausaAfastamentoFacadeImp implements CausaAfastamentoFacade {

	@EJB
	private CausaAfastamentoDAO dao;
	
	@Override
	public CausaAfastamento inserir(CausaAfastamento causaAfastamento) throws AppException {
		TrataErro.trataParametroNull(causaAfastamento, TipoOperacao.INSERCAO);
		return dao.inserir(causaAfastamento);
	}
	
	@Override
	public CausaAfastamento alterar(CausaAfastamento causaAfastamento) throws AppException {
		TrataErro.trataParametroNull(causaAfastamento, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(causaAfastamento.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(causaAfastamento.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(causaAfastamento);
	}
	
	@Override
	public void excluir(CausaAfastamento causaAfastamento) throws AppException {
		TrataErro.trataParametroNull(causaAfastamento, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(causaAfastamento.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(causaAfastamento.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(causaAfastamento);
	}

	@Override
	public List<CausaAfastamento> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CausaAfastamento consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
