package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.FaltaDAO;
import br.com.folha.entity.Falta;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FaltaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="FaltaFacade")
public class FaltaFacadeImp implements FaltaFacade {

	@EJB
	private FaltaDAO dao;
	
	@Override
	public Falta inserir(Falta falta) throws AppException {
		TrataErro.trataParametroNull(falta, TipoOperacao.INSERCAO);
		return dao.inserir(falta);
	}
	
	@Override
	public Falta alterar(Falta falta) throws AppException {
		TrataErro.trataParametroNull(falta, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(falta.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(falta.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(falta);
	}
	
	@Override
	public void excluir(Falta falta) throws AppException {
		TrataErro.trataParametroNull(falta, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(falta.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(falta.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(falta);
	}

	@Override
	public List<Falta> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Falta consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
