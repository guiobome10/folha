package br.com.folha.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.folha.dao.CidadeDAO;
import br.com.folha.entity.Cidade;
import br.com.folha.entity.Estado;

@Stateless(name="CidadeDAO")
public class CidadeDAOImp extends GenericDAOImp<Cidade> implements CidadeDAO {

	public CidadeDAOImp() { 
		super(Cidade.class);
	}

	@Override
	public List<Cidade> listarCidadesPorEstado(Estado estado) {
		Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("estado", estado);    
 
        return super.procurarListaRegistros(Cidade.LISTAR_POR_ESTADO, parametros);
	}

}
