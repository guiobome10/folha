package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.NaturezaEmpresa;
import br.com.folha.facade.NaturezaEmpresaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=NaturezaEmpresa.class,value="naturezaEmpresaConverter")
public class NaturezaEmpresaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			NaturezaEmpresaFacade facade = FacadeLocator.getService(NaturezaEmpresaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		NaturezaEmpresa naturezaEmpresa = (NaturezaEmpresa)arg2;
	    return String.valueOf(naturezaEmpresa.getId());
	  }
}
