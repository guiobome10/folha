package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.CategoriaFuncionario;
import br.com.folha.facade.CategoriaFuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=CategoriaFuncionario.class,value="categoriaFuncionarioConverter")
public class CategoriaFuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CategoriaFuncionarioFacade facade = FacadeLocator.getService(CategoriaFuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		CategoriaFuncionario categoriaFuncionario = (CategoriaFuncionario)arg2;
	    return String.valueOf(categoriaFuncionario.getId());
	  }
}
