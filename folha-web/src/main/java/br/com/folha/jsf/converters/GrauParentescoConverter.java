package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.GrauParentesco;
import br.com.folha.facade.GrauParentescoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=GrauParentesco.class,value="grauParentescoConverter")
public class GrauParentescoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			GrauParentescoFacade facade = FacadeLocator.getService(GrauParentescoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		GrauParentesco grauParentesco = (GrauParentesco)arg2;
	    return String.valueOf(grauParentesco.getId());
	  }
}
