package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoJornada;
import br.com.folha.facade.TipoJornadaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoJornada.class,value="tipoJornadaConverter")
public class TipoJornadaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoJornadaFacade facade = FacadeLocator.getService(TipoJornadaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoJornada tipoJornada = (TipoJornada)arg2;
	    return String.valueOf(tipoJornada.getId());
	  }
}
