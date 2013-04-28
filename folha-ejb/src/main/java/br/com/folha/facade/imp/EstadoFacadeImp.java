package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import br.com.folha.dao.EstadoDAO;
import br.com.folha.entity.Estado;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EstadoFacade;
import br.com.folha.utils.TrataErro;

@Singleton(name="EstadoFacade")
public class EstadoFacadeImp implements EstadoFacade {

	@EJB
	private EstadoDAO dao;
	
	@Override
	public Estado inserir(Estado estado) throws AppException {
		TrataErro.trataParametroNull(estado, TipoOperacao.INSERCAO);
		return dao.inserir(estado);
	}
	
	@Override
	public Estado alterar(Estado estado) throws AppException {
		TrataErro.trataParametroNull(estado, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(estado.getSigla(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroVazio(estado.getSigla(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(estado);
	}
	
	@Override
	public void excluir(Estado estado) throws AppException {
		TrataErro.trataParametroNull(estado, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(estado.getSigla(), TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroVazio(estado.getSigla(), TipoOperacao.EXCLUSAO);
		dao.excluir(estado);
	}

	@Override
	public List<Estado> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Estado consultar(String sigla) throws AppException {
		TrataErro.trataParametroNull(sigla, TipoOperacao.CONSULTA);
		TrataErro.trataParametroVazio(sigla, TipoOperacao.CONSULTA);
		return dao.getBySigla(sigla);
	}
	
}
