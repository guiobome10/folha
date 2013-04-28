package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.FeriasDAO;
import br.com.folha.entity.Ferias;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.FeriasFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="FeriasFacade")
public class FeriasFacadeImp implements FeriasFacade {

	@EJB
	private FeriasDAO dao;
	
	@Override
	public Ferias inserir(Ferias ferias) throws AppException {
		TrataErro.trataParametroNull(ferias, TipoOperacao.INSERCAO);
		return dao.inserir(ferias);
	}
	
	@Override
	public Ferias alterar(Ferias ferias) throws AppException {
		TrataErro.trataParametroNull(ferias, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(ferias.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(ferias.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(ferias);
	}
	
	@Override
	public void excluir(Ferias ferias) throws AppException {
		TrataErro.trataParametroNull(ferias, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(ferias.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(ferias.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(ferias);
	}

	@Override
	public List<Ferias> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Ferias consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
