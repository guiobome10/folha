package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.GrauParentescoDAO;
import br.com.folha.entity.GrauParentesco;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.GrauParentescoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="GrauParentescoFacade")
public class GrauParentescoFacadeImp implements GrauParentescoFacade {

	@EJB
	private GrauParentescoDAO dao;
	
	@Override
	public GrauParentesco inserir(GrauParentesco grauParentesco) throws AppException {
		TrataErro.trataParametroNull(grauParentesco, TipoOperacao.INSERCAO);
		return dao.inserir(grauParentesco);
	}
	
	@Override
	public GrauParentesco alterar(GrauParentesco grauParentesco) throws AppException {
		TrataErro.trataParametroNull(grauParentesco, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(grauParentesco.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(grauParentesco.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(grauParentesco);
	}
	
	@Override
	public void excluir(GrauParentesco grauParentesco) throws AppException {
		TrataErro.trataParametroNull(grauParentesco, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(grauParentesco.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(grauParentesco.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(grauParentesco);
	}

	@Override
	public List<GrauParentesco> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public GrauParentesco consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
