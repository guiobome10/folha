package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.EscolaridadeDAO;
import br.com.folha.entity.Escolaridade;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EscolaridadeFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="EscolaridadeFacade")
public class EscolaridadeFacadeImp implements EscolaridadeFacade {

	@EJB
	private EscolaridadeDAO dao;
	
	@Override
	public Escolaridade inserir(Escolaridade escolaridade) throws AppException {
		TrataErro.trataParametroNull(escolaridade, TipoOperacao.INSERCAO);
		return dao.inserir(escolaridade);
	}
	
	@Override
	public Escolaridade alterar(Escolaridade escolaridade) throws AppException {
		TrataErro.trataParametroNull(escolaridade, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(escolaridade.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(escolaridade.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(escolaridade);
	}
	
	@Override
	public void excluir(Escolaridade escolaridade) throws AppException {
		TrataErro.trataParametroNull(escolaridade, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(escolaridade.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(escolaridade.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(escolaridade);
	}

	@Override
	public List<Escolaridade> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Escolaridade consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
