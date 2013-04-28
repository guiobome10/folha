package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoPagamentoFuncionarioDAO;
import br.com.folha.entity.TipoPagamentoFuncionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoPagamentoFuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoPagamentoFuncionarioFacade")
public class TipoPagamentoFuncionarioFacadeImp implements TipoPagamentoFuncionarioFacade {

	@EJB
	private TipoPagamentoFuncionarioDAO dao;
	
	@Override
	public TipoPagamentoFuncionario inserir(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoPagamentoFuncionario, TipoOperacao.INSERCAO);
		return dao.inserir(tipoPagamentoFuncionario);
	}
	
	@Override
	public TipoPagamentoFuncionario alterar(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoPagamentoFuncionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoPagamentoFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoPagamentoFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoPagamentoFuncionario);
	}
	
	@Override
	public void excluir(TipoPagamentoFuncionario tipoPagamentoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoPagamentoFuncionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoPagamentoFuncionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoPagamentoFuncionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoPagamentoFuncionario);
	}

	@Override
	public List<TipoPagamentoFuncionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoPagamentoFuncionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
