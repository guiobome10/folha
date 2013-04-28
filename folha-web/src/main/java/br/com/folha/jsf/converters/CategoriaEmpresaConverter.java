package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.CategoriaEmpresa;
import br.com.folha.facade.CategoriaEmpresaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=CategoriaEmpresa.class,value="categoriaEmpresaConverter")
public class CategoriaEmpresaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CategoriaEmpresaFacade facade = FacadeLocator.getService(CategoriaEmpresaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		CategoriaEmpresa categoriaEmpresa = (CategoriaEmpresa)arg2;
	    return String.valueOf(categoriaEmpresa.getId());
	  }
}
