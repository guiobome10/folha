package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Departamento;
import br.com.folha.facade.DepartamentoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Departamento.class,value="departamentoConverter")
public class DepartamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			DepartamentoFacade facade = FacadeLocator.getService(DepartamentoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Departamento departamento = (Departamento)arg2;
	    return String.valueOf(departamento.getId());
	  }
}
