package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.BancoDAO;
import br.com.folha.entity.Banco;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.BancoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="BancoFacade")
public class BancoFacadeImp implements BancoFacade {

	@EJB
	private BancoDAO dao;
	
	@Override
	public Banco inserir(Banco banco) throws AppException {
		TrataErro.trataParametroNull(banco, TipoOperacao.INSERCAO);
		TrataErro.trataParametroNull(banco.getCodigo(), TipoOperacao.INSERCAO);
		TrataErro.trataIdZerado(banco.getCodigo(), TipoOperacao.INSERCAO);
		return dao.inserir(banco);
	}
	
	@Override
	public Banco alterar(Banco banco) throws AppException {
		TrataErro.trataParametroNull(banco, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(banco.getCodigo(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(banco.getCodigo(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(banco);
	}
	
	@Override
	public void excluir(Banco banco) throws AppException {
		TrataErro.trataParametroNull(banco, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(banco.getCodigo(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(banco.getCodigo(), TipoOperacao.EXCLUSAO);
		dao.excluir(banco);
	}

	@Override
	public List<Banco> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Banco consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
