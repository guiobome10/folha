package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoJornadaDAO;
import br.com.folha.entity.TipoJornada;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoJornadaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoJornadaFacade")
public class TipoJornadaFacadeImp implements TipoJornadaFacade {

	@EJB
	private TipoJornadaDAO dao;
	
	@Override
	public TipoJornada inserir(TipoJornada tipoJornada) throws AppException {
		TrataErro.trataParametroNull(tipoJornada, TipoOperacao.INSERCAO);
		return dao.inserir(tipoJornada);
	}
	
	@Override
	public TipoJornada alterar(TipoJornada tipoJornada) throws AppException {
		TrataErro.trataParametroNull(tipoJornada, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoJornada.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoJornada.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoJornada);
	}
	
	@Override
	public void excluir(TipoJornada tipoJornada) throws AppException {
		TrataErro.trataParametroNull(tipoJornada, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoJornada.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoJornada.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoJornada);
	}

	@Override
	public List<TipoJornada> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoJornada consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
