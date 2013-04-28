package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CidadeDAO;
import br.com.folha.entity.Cidade;
import br.com.folha.entity.Estado;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CidadeFacade")
public class CidadeFacadeImp implements CidadeFacade {

	@EJB
	private CidadeDAO dao;
	
	@Override
	public Cidade inserir(Cidade cidade) throws AppException {
		TrataErro.trataParametroNull(cidade, TipoOperacao.INSERCAO);
		TrataErro.trataParametroNull(cidade.getId(), TipoOperacao.INSERCAO);
		TrataErro.trataIdZerado(cidade.getId(), TipoOperacao.INSERCAO);
		return dao.inserir(cidade);
	}
	
	@Override
	public Cidade alterar(Cidade cidade) throws AppException {
		TrataErro.trataParametroNull(cidade, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(cidade.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(cidade.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(cidade);
	}
	
	@Override
	public void excluir(Cidade cidade) throws AppException {
		TrataErro.trataParametroNull(cidade, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(cidade.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(cidade.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(cidade);
	}

	@Override
	public List<Cidade> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Cidade consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

	@Override
	public List<Cidade> listarCidadePorEstado(Estado estado)
			throws AppException {
		TrataErro.trataParametroNull(estado, TipoOperacao.LISTAGEM);
		TrataErro.trataParametroVazio(estado.getSigla(), TipoOperacao.LISTAGEM);
		return dao.listarCidadesPorEstado(estado);
	}
	
}
