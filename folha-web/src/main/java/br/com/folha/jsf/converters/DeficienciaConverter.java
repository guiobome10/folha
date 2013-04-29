package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Deficiencia;
import br.com.folha.facade.DeficienciaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Deficiencia.class,value="deficienciaConverter")
public class DeficienciaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			DeficienciaFacade facade = FacadeLocator.getService(DeficienciaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Deficiencia deficiencia = (Deficiencia)arg2;
	    return String.valueOf(deficiencia.getId());
	  }
}
