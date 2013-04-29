package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.EstadoCivilDAO;
import br.com.folha.entity.EstadoCivil;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EstadoCivilFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="EstadoCivilFacade")
public class EstadoCivilFacadeImp implements EstadoCivilFacade {

	@EJB
	private EstadoCivilDAO dao;
	
	@Override
	public EstadoCivil inserir(EstadoCivil estadoCivil) throws AppException {
		TrataErro.trataParametroNull(estadoCivil, TipoOperacao.INSERCAO);
		return dao.inserir(estadoCivil);
	}
	
	@Override
	public EstadoCivil alterar(EstadoCivil estadoCivil) throws AppException {
		TrataErro.trataParametroNull(estadoCivil, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(estadoCivil.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(estadoCivil.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(estadoCivil);
	}
	
	@Override
	public void excluir(EstadoCivil estadoCivil) throws AppException {
		TrataErro.trataParametroNull(estadoCivil, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(estadoCivil.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(estadoCivil.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(estadoCivil);
	}

	@Override
	public List<EstadoCivil> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public EstadoCivil consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
