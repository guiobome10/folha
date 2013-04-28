package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.BaseInsalubridadeFuncionarioDAO;
import br.com.folha.entity.BaseInsalubridadeFuncionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BaseInsalubridadeFuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="BaseInsalubridadeFuncionarioFacade")
public class BaseInsalubridadeFuncionarioFacadeImp implements BaseInsalubridadeFuncionarioFacade {

	@EJB
	private BaseInsalubridadeFuncionarioDAO dao;
	
	@Override
	public BaseInsalubridadeFuncionario inserir(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException {
		TrataErro.trataParametroNull(baseInsalubridadeFuncionario, TipoOperacao.INSERCAO);
		return dao.inserir(baseInsalubridadeFuncionario);
	}
	
	@Override
	public BaseInsalubridadeFuncionario alterar(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException {
		TrataErro.trataParametroNull(baseInsalubridadeFuncionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(baseInsalubridadeFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(baseInsalubridadeFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(baseInsalubridadeFuncionario);
	}
	
	@Override
	public void excluir(BaseInsalubridadeFuncionario baseInsalubridadeFuncionario) throws AppException {
		TrataErro.trataParametroNull(baseInsalubridadeFuncionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(baseInsalubridadeFuncionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(baseInsalubridadeFuncionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(baseInsalubridadeFuncionario);
	}

	@Override
	public List<BaseInsalubridadeFuncionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public BaseInsalubridadeFuncionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
