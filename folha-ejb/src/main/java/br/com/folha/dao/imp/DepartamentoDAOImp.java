package br.com.folha.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.folha.dao.DepartamentoDAO;
import br.com.folha.entity.Departamento;
import br.com.folha.entity.Sindicato;
import br.com.folha.exception.AppException;

@Stateless(name="DepartamentoDAO")
public class DepartamentoDAOImp extends GenericDAOImp<Departamento> implements DepartamentoDAO {

	public DepartamentoDAOImp() {
		super(Departamento.class);
	}

	@Override
	public List<Departamento> listarDepartamentosPorSindicato(
			Sindicato sindicato) throws AppException {
		Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("sindicato", sindicato);    
 
        return super.procurarListaRegistros(Departamento.LISTAR_DEPARTAMENTO_POR_SINDICATO, parametros);
	}
}
