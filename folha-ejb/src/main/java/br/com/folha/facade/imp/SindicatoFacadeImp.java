package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.SindicatoDAO;
import br.com.folha.entity.Sindicato;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.SindicatoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="SindicatoFacade")
public class SindicatoFacadeImp implements SindicatoFacade {

	@EJB
	private SindicatoDAO dao;
	 
	@Override
	public Sindicato inserir(Sindicato sindicato) throws AppException {
		TrataErro.trataParametroNull(sindicato, TipoOperacao.INSERCAO);
		return dao.inserir(sindicato);
	}
	
	@Override
	public Sindicato alterar(Sindicato sindicato) throws AppException {
		TrataErro.trataParametroNull(sindicato, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(sindicato.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(sindicato.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(sindicato);
	}
	
	@Override
	public void excluir(Sindicato sindicato) throws AppException {
		TrataErro.trataParametroNull(sindicato, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(sindicato.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(sindicato.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(sindicato);
	}

	@Override
	public List<Sindicato> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Sindicato consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}

}
