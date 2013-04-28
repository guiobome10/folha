package br.com.folha.dao.imp;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.folha.dao.CargoDAO;
import br.com.folha.entity.Cargo;
import br.com.folha.entity.Departamento;

@Stateless(name="CargoDAO")
public class CargoDAOImp extends GenericDAOImp<Cargo> implements CargoDAO {

	public CargoDAOImp() {
		super(Cargo.class);
	}

	@Override
	public List<Cargo> listarCargosPorDepartamento(Departamento departamento) {
		TypedQuery<Cargo> query = super.getEntityManager().createNamedQuery(Cargo.LISTAR_CARGOS_POR_DEPARTAMENTO, Cargo.class);
        query.setParameter("departamento", departamento);    
		return query.getResultList();
	}
}
