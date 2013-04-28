package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CategoriaEmpresaDAO;
import br.com.folha.entity.CategoriaEmpresa;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaEmpresaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CategoriaEmpresaFacade")
public class CategoriaEmpresaFacadeImp implements CategoriaEmpresaFacade {

	@EJB
	private CategoriaEmpresaDAO dao;
	
	@Override
	public CategoriaEmpresa inserir(CategoriaEmpresa categoriaEmpresa) throws AppException {
		TrataErro.trataParametroNull(categoriaEmpresa, TipoOperacao.INSERCAO);
		return dao.inserir(categoriaEmpresa);
	}
	
	@Override
	public CategoriaEmpresa alterar(CategoriaEmpresa categoriaEmpresa) throws AppException {
		TrataErro.trataParametroNull(categoriaEmpresa, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(categoriaEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(categoriaEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(categoriaEmpresa);
	}
	
	@Override
	public void excluir(CategoriaEmpresa categoriaEmpresa) throws AppException {
		TrataErro.trataParametroNull(categoriaEmpresa, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(categoriaEmpresa.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(categoriaEmpresa.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(categoriaEmpresa);
	}

	@Override
	public List<CategoriaEmpresa> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CategoriaEmpresa consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
