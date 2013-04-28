package br.com.folha.dao.imp;

import javax.ejb.Stateless;

import br.com.folha.dao.BeneficioDAO;
import br.com.folha.entity.Beneficio;

@Stateless(name="BeneficioDAO")
public class BeneficioDAOImp extends GenericDAOImp<Beneficio> implements BeneficioDAO {

	public BeneficioDAOImp() { 
		super(Beneficio.class);
	}

}
