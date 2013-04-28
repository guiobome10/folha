package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.CategoriaCNH;
import br.com.folha.facade.CategoriaCNHFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=CategoriaCNH.class,value="categoriaCNHConverter")
public class CategoriaCNHConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CategoriaCNHFacade facade = FacadeLocator.getService(CategoriaCNHFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		CategoriaCNH categoriaCNH = (CategoriaCNH)arg2;
	    return String.valueOf(categoriaCNH.getId());
	  }
}
