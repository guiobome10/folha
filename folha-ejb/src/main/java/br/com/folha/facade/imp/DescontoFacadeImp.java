package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.DescontoDAO;
import br.com.folha.entity.Desconto;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.DescontoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="DescontoFacade")
public class DescontoFacadeImp implements DescontoFacade {

	@EJB
	private DescontoDAO dao;
	
	@Override
	public Desconto inserir(Desconto desconto) throws AppException {
		TrataErro.trataParametroNull(desconto, TipoOperacao.INSERCAO);
		return dao.inserir(desconto);
	}
	
	@Override
	public Desconto alterar(Desconto desconto) throws AppException {
		TrataErro.trataParametroNull(desconto, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(desconto.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(desconto.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(desconto);
	}
	
	@Override
	public void excluir(Desconto desconto) throws AppException {
		TrataErro.trataParametroNull(desconto, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(desconto.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(desconto.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(desconto);
	}

	@Override
	public List<Desconto> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Desconto consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
