package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CondicaoDependenteDAO;
import br.com.folha.entity.CondicaoDependente;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CondicaoDependenteFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CondicaoDependenteFacade")
public class CondicaoDependenteFacadeImp implements CondicaoDependenteFacade {

	@EJB
	private CondicaoDependenteDAO dao;
	
	@Override
	public CondicaoDependente inserir(CondicaoDependente condicaoDependente) throws AppException {
		TrataErro.trataParametroNull(condicaoDependente, TipoOperacao.INSERCAO);
		return dao.inserir(condicaoDependente);
	}
	
	@Override
	public CondicaoDependente alterar(CondicaoDependente condicaoDependente) throws AppException {
		TrataErro.trataParametroNull(condicaoDependente, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(condicaoDependente.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(condicaoDependente.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(condicaoDependente);
	}
	
	@Override
	public void excluir(CondicaoDependente condicaoDependente) throws AppException {
		TrataErro.trataParametroNull(condicaoDependente, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(condicaoDependente.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(condicaoDependente.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(condicaoDependente);
	}

	@Override
	public List<CondicaoDependente> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CondicaoDependente consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
