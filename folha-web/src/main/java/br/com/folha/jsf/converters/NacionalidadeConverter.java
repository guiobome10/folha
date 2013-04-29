package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Nacionalidade;
import br.com.folha.facade.NacionalidadeFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Nacionalidade.class,value="nacionalidadeConverter")
public class NacionalidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			NacionalidadeFacade facade = FacadeLocator.getService(NacionalidadeFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Nacionalidade nacionalidade = (Nacionalidade)arg2;
	    return String.valueOf(nacionalidade.getId());
	  }
}
