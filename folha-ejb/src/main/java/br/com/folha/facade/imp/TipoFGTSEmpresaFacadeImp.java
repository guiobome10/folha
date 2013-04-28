package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TipoFGTSEmpresaDAO;
import br.com.folha.entity.TipoFGTSEmpresa;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TipoFGTSEmpresaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TipoFGTSEmpresaFacade")
public class TipoFGTSEmpresaFacadeImp implements TipoFGTSEmpresaFacade {

	@EJB
	private TipoFGTSEmpresaDAO dao;
	
	@Override
	public TipoFGTSEmpresa inserir(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException {
		TrataErro.trataParametroNull(tipoFGTSEmpresa, TipoOperacao.INSERCAO);
		return dao.inserir(tipoFGTSEmpresa);
	}
	
	@Override
	public TipoFGTSEmpresa alterar(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException {
		TrataErro.trataParametroNull(tipoFGTSEmpresa, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(tipoFGTSEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(tipoFGTSEmpresa.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(tipoFGTSEmpresa);
	}
	
	@Override
	public void excluir(TipoFGTSEmpresa tipoFGTSEmpresa) throws AppException {
		TrataErro.trataParametroNull(tipoFGTSEmpresa, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(tipoFGTSEmpresa.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(tipoFGTSEmpresa.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(tipoFGTSEmpresa);
	}

	@Override
	public List<TipoFGTSEmpresa> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public TipoFGTSEmpresa consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
