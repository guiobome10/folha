package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoRaisFuncionarioDAO;
import br.com.folha.entity.TipoRaisFuncionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoRaisFuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoRaisFuncionarioFacade")
public class TipoRaisFuncionarioFacadeImp implements TipoRaisFuncionarioFacade {

	@EJB
	private TipoRaisFuncionarioDAO dao;
	
	@Override
	public TipoRaisFuncionario inserir(TipoRaisFuncionario tipoRaisFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoRaisFuncionario, TipoOperacao.INSERCAO);
		TrataErro.trataParametroNull(tipoRaisFuncionario.getId(), TipoOperacao.INSERCAO);
		return dao.inserir(tipoRaisFuncionario);
	}
	
	@Override
	public TipoRaisFuncionario alterar(TipoRaisFuncionario tipoRaisFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoRaisFuncionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoRaisFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoRaisFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoRaisFuncionario);
	}
	
	@Override
	public void excluir(TipoRaisFuncionario tipoRaisFuncionario) throws AppException {
		TrataErro.trataParametroNull(tipoRaisFuncionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoRaisFuncionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoRaisFuncionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoRaisFuncionario);
	}

	@Override
	public List<TipoRaisFuncionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoRaisFuncionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
