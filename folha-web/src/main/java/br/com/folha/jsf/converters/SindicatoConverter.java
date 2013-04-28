package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Sindicato;
import br.com.folha.facade.SindicatoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Sindicato.class,value="sindicatoConverter")
public class SindicatoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			SindicatoFacade facade = FacadeLocator.getService(SindicatoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Sindicato sindicato = (Sindicato)arg2;
	    return String.valueOf(sindicato.getId());
	  }
}
