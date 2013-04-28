package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.CondicaoDependente;
import br.com.folha.facade.CondicaoDependenteFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=CondicaoDependente.class,value="condicaoDependenteConverter")
public class CondicaoDependenteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CondicaoDependenteFacade facade = FacadeLocator.getService(CondicaoDependenteFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		CondicaoDependente condicaoDependente = (CondicaoDependente)arg2;
	    return String.valueOf(condicaoDependente.getId());
	  }
}
