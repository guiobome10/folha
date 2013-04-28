package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.BaseInsalubridadeFuncionario;
import br.com.folha.facade.BaseInsalubridadeFuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=BaseInsalubridadeFuncionario.class,value="baseInsalubridadeFuncionarioConverter")
public class BaseInsalubridadeFuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			BaseInsalubridadeFuncionarioFacade facade = FacadeLocator.getService(BaseInsalubridadeFuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		BaseInsalubridadeFuncionario baseInsalubridadeFuncionario = (BaseInsalubridadeFuncionario)arg2;
	    return String.valueOf(baseInsalubridadeFuncionario.getId());
	  }
}
