package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Cor;
import br.com.folha.facade.CorFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Cor.class,value="corConverter")
public class CorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CorFacade facade = FacadeLocator.getService(CorFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Cor cor = (Cor)arg2;
	    return String.valueOf(cor.getId());
	  }
}
