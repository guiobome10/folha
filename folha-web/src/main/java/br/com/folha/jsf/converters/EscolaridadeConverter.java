package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Escolaridade;
import br.com.folha.facade.EscolaridadeFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Escolaridade.class,value="escolaridadeConverter")
public class EscolaridadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			EscolaridadeFacade facade = FacadeLocator.getService(EscolaridadeFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Escolaridade escolaridade = (Escolaridade)arg2;
	    return String.valueOf(escolaridade.getId());
	  }
}
