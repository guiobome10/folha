package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.CorDAO;
import br.com.folha.entity.Cor;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.CorFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="CorFacade")
public class CorFacadeImp implements CorFacade {

	@EJB
	private CorDAO dao;
	
	@Override
	public Cor inserir(Cor cor) throws AppException {
		TrataErro.trataParametroNull(cor, TipoOperacao.INSERCAO);
		return dao.inserir(cor);
	}
	
	@Override
	public Cor alterar(Cor cor) throws AppException {
		TrataErro.trataParametroNull(cor, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(cor.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(cor.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(cor);
	}
	
	@Override
	public void excluir(Cor cor) throws AppException {
		TrataErro.trataParametroNull(cor, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(cor.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(cor.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(cor);
	}

	@Override
	public List<Cor> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Cor consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
}
