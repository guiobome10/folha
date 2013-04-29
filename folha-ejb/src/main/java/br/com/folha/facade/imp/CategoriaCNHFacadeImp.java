package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CategoriaCNHDAO;
import br.com.folha.entity.CategoriaCNH;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaCNHFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CategoriaCNHFacade")
public class CategoriaCNHFacadeImp implements CategoriaCNHFacade {

	@EJB
	private CategoriaCNHDAO dao;
	
	@Override
	public CategoriaCNH inserir(CategoriaCNH categoriaCNH) throws AppException {
		TrataErro.trataParametroNull(categoriaCNH, TipoOperacao.INSERCAO);
		return dao.inserir(categoriaCNH);
	}
	
	@Override
	public CategoriaCNH alterar(CategoriaCNH categoriaCNH) throws AppException {
		TrataErro.trataParametroNull(categoriaCNH, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(categoriaCNH.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(categoriaCNH.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(categoriaCNH);
	}
	
	@Override
	public void excluir(CategoriaCNH categoriaCNH) throws AppException {
		TrataErro.trataParametroNull(categoriaCNH, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(categoriaCNH.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(categoriaCNH.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(categoriaCNH);
	}

	@Override
	public List<CategoriaCNH> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CategoriaCNH consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
