package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoExposicaoFuncionarioDAO;
import br.com.folha.entity.TipoExposicaoFuncionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoExposicaoFuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoExposicaoFuncionarioFacade")
public class TipoExposicaoFuncionarioFacadeImp implements TipoExposicaoFuncionarioFacade {

	@EJB
	private TipoExposicaoFuncionarioDAO dao;
	
	@Override
	public TipoExposicaoFuncionario inserir(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoExposicaoFuncionario, TipoOperacao.INSERCAO);
		return dao.inserir(tipoExposicaoFuncionario);
	}
	
	@Override
	public TipoExposicaoFuncionario alterar(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoExposicaoFuncionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoExposicaoFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoExposicaoFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoExposicaoFuncionario);
	}
	
	@Override
	public void excluir(TipoExposicaoFuncionario tipoExposicaoFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoExposicaoFuncionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoExposicaoFuncionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoExposicaoFuncionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoExposicaoFuncionario);
	}

	@Override
	public List<TipoExposicaoFuncionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoExposicaoFuncionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
