package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CategoriaFuncionarioDAO;
import br.com.folha.entity.CategoriaFuncionario;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CategoriaFuncionarioFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CategoriaFuncionarioFacade")
public class CategoriaFuncionarioFacadeImp implements CategoriaFuncionarioFacade {

	@EJB
	private CategoriaFuncionarioDAO dao;
	
	@Override
	public CategoriaFuncionario inserir(CategoriaFuncionario categoriaFuncionario) throws AppException {
		TrataErro.trataParametroNull(categoriaFuncionario, TipoOperacao.INSERCAO);
		return dao.inserir(categoriaFuncionario);
	}
	
	@Override
	public CategoriaFuncionario alterar(CategoriaFuncionario categoriaFuncionario) throws AppException {
		TrataErro.trataParametroNull(categoriaFuncionario, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(categoriaFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(categoriaFuncionario.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(categoriaFuncionario);
	}
	
	@Override
	public void excluir(CategoriaFuncionario categoriaFuncionario) throws AppException {
		TrataErro.trataParametroNull(categoriaFuncionario, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(categoriaFuncionario.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(categoriaFuncionario.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(categoriaFuncionario);
	}

	@Override
	public List<CategoriaFuncionario> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public CategoriaFuncionario consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
