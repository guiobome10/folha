package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Cidade;
import br.com.folha.facade.CidadeFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Cidade.class,value="cidadeConverter")
public class CidadeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CidadeFacade facade = FacadeLocator.getService(CidadeFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Cidade cidade = (Cidade)arg2;
	    return String.valueOf(cidade.getId());
	  }
}
