package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.NaturezaEmpresaDAO;
import br.com.folha.entity.NaturezaEmpresa;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.NaturezaEmpresaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="NaturezaEmpresaFacade")
public class NaturezaEmpresaFacadeImp implements NaturezaEmpresaFacade {

	@EJB
	private NaturezaEmpresaDAO dao;
	
	@Override
	public NaturezaEmpresa inserir(NaturezaEmpresa naturezaEmpresa) throws AppException {
		TrataErro.trataParametroNull(naturezaEmpresa, TipoOperacao.INSERCAO);
		return dao.inserir(naturezaEmpresa);
	}
	
	@Override
	public NaturezaEmpresa alterar(NaturezaEmpresa naturezaEmpresa) throws AppException {
		TrataErro.trataParametroNull(naturezaEmpresa, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(naturezaEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(naturezaEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(naturezaEmpresa);
	}
	
	@Override
	public void excluir(NaturezaEmpresa naturezaEmpresa) throws AppException {
		TrataErro.trataParametroNull(naturezaEmpresa, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(naturezaEmpresa.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(naturezaEmpresa.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(naturezaEmpresa);
	}

	@Override
	public List<NaturezaEmpresa> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public NaturezaEmpresa consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
