package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.NacionalidadeDAO;
import br.com.folha.entity.Nacionalidade;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.NacionalidadeFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="NacionalidadeFacade")
public class NacionalidadeFacadeImp implements NacionalidadeFacade {

	@EJB
	private NacionalidadeDAO dao;
	
	@Override
	public Nacionalidade inserir(Nacionalidade nacionalidade) throws AppException {
		TrataErro.trataParametroNull(nacionalidade, TipoOperacao.INSERCAO);
		return dao.inserir(nacionalidade);
	}
	
	@Override
	public Nacionalidade alterar(Nacionalidade nacionalidade) throws AppException {
		TrataErro.trataParametroNull(nacionalidade, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(nacionalidade.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(nacionalidade.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(nacionalidade);
	}
	
	@Override
	public void excluir(Nacionalidade nacionalidade) throws AppException {
		TrataErro.trataParametroNull(nacionalidade, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(nacionalidade.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(nacionalidade.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(nacionalidade);
	}

	@Override
	public List<Nacionalidade> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Nacionalidade consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
