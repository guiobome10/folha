package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.EmpresaDAO;
import br.com.folha.entity.Empresa;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EmpresaFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="EmpresaFacade")
public class EmpresaFacadeImp implements EmpresaFacade {

	@EJB
	private EmpresaDAO dao;
	
	@Override
	public Empresa inserir(Empresa empresa) throws AppException {
		TrataErro.trataParametroNull(empresa, TipoOperacao.INSERCAO);
		return dao.inserir(empresa);
	}
	
	@Override
	public Empresa alterar(Empresa empresa) throws AppException {
		TrataErro.trataParametroNull(empresa, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(empresa.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(empresa.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(empresa);
	}
	
	@Override
	public void excluir(Empresa empresa) throws AppException {
		TrataErro.trataParametroNull(empresa, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(empresa.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(empresa.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(empresa);
	}

	@Override
	public List<Empresa> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Empresa consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
