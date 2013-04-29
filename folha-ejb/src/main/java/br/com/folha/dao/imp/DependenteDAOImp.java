package br.com.folha.dao.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.folha.dao.DependenteDAO;
import br.com.folha.entity.Dependente;
import br.com.folha.entity.Funcionario;
import br.com.folha.exception.AppException;


@Stateless(name="DependenteDAO")
public class DependenteDAOImp extends GenericDAOImp<Dependente> implements DependenteDAO {

	public DependenteDAOImp() {
		super(Dependente.class);
	}
	
	@Override
	public List<Dependente> listarPorFuncionario(Funcionario funcionario) throws AppException{
		Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("funcionario", funcionario);    
        
		return super.procurarListaRegistros(Dependente.LISTAR_POR_FUNCIONARIO, parametros);
	}
}
