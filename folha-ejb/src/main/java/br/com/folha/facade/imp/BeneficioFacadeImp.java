package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.BeneficioDAO;
import br.com.folha.entity.Beneficio;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BeneficioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="BeneficioFacade")
public class BeneficioFacadeImp implements BeneficioFacade {

	@EJB
	private BeneficioDAO dao;
	
	@Override
	public Beneficio inserir(Beneficio beneficio) throws AppException {
		TrataErro.trataParametroNull(beneficio, TipoOperacao.INSERCAO);
		return dao.inserir(beneficio);
	}
	
	@Override
	public Beneficio alterar(Beneficio beneficio) throws AppException {
		TrataErro.trataParametroNull(beneficio, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(beneficio.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(beneficio.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(beneficio);
	}
	
	@Override
	public void excluir(Beneficio beneficio) throws AppException {
		TrataErro.trataParametroNull(beneficio, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(beneficio.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(beneficio.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(beneficio);
	}

	@Override
	public List<Beneficio> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Beneficio consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
