package br.com.folha.facade.imp;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.folha.dao.TurnoDAO;
import br.com.folha.entity.Turno;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.TurnoFacade;
import br.com.folha.utils.TrataErro;

@Stateless(name="TurnoFacade")
public class TurnoFacadeImp implements TurnoFacade {

	@EJB
	private TurnoDAO dao;
	
	@Override
	public Turno inserir(Turno turno) throws AppException {
		TrataErro.trataParametroNull(turno, TipoOperacao.INSERCAO);
		return dao.inserir(turno);
	}
	
	@Override
	public Turno alterar(Turno turno) throws AppException {
		TrataErro.trataParametroNull(turno, TipoOperacao.ATUALIZACAO);
		TrataErro.trataParametroNull(turno.getId(), TipoOperacao.ATUALIZACAO);
		TrataErro.trataIdZerado(turno.getId(), TipoOperacao.ATUALIZACAO);
		return dao.alterar(turno);
	}
	
	@Override
	public void excluir(Turno turno) throws AppException {
		TrataErro.trataParametroNull(turno, TipoOperacao.EXCLUSAO);
		TrataErro.trataParametroNull(turno.getId(), TipoOperacao.EXCLUSAO);
		TrataErro.trataIdZerado(turno.getId(), TipoOperacao.EXCLUSAO);
		dao.excluir(turno);
	}

	@Override
	public List<Turno> listar() throws AppException {
		try {
			return dao.listar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
	@Override
	public Turno consultar(Long id) throws AppException {
		TrataErro.trataParametroNull(id, TipoOperacao.CONSULTA);
		TrataErro.trataIdZerado(id, TipoOperacao.CONSULTA);
		return dao.consultar(id);
	}
	
}
