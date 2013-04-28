package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Empresa;
import br.com.folha.facade.EmpresaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Empresa.class,value="empresaConverter")
public class EmpresaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			EmpresaFacade facade = FacadeLocator.getService(EmpresaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Empresa empresa = (Empresa)arg2;
	    return String.valueOf(empresa.getId());
	  }
}
