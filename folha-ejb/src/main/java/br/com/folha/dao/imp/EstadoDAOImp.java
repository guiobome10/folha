package br.com.folha.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.folha.dao.EstadoDAO;
import br.com.folha.entity.Estado;
import br.com.folha.enuns.TipoException;
import br.com.folha.exception.AppException;

@Stateless(name="EstadoDAO")
public class EstadoDAOImp extends GenericDAOImp<Estado> implements EstadoDAO {

	public EstadoDAOImp() {
		super(Estado.class);
	}

	@Override
	public Estado getBySigla(String sigla) throws AppException {
		Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("sigla", sigla);    
 
		try {
			return procurarRegistroUnico(Estado.BUSCAR_POR_SIGLA, parametros);
		} catch (NoResultException e) {
			e.printStackTrace();
			throw new AppException(e, TipoException.WARN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException(e, TipoException.ERROR);
		}
	}
	
	@Override
	public List<Estado> listar() {
		TypedQuery<Estado> q = getEntityManager().createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
		return q.getResultList();
	}

}
