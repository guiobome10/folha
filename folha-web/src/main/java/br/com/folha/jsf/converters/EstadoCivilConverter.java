package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.EstadoCivil;
import br.com.folha.facade.EstadoCivilFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=EstadoCivil.class,value="estadoCivilConverter")
public class EstadoCivilConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			EstadoCivilFacade facade = FacadeLocator.getService(EstadoCivilFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		EstadoCivil estadoCivil = (EstadoCivil)arg2;
	    return String.valueOf(estadoCivil.getId());
	  }
}
