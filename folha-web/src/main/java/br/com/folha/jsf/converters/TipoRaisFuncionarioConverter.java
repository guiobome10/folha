package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoRaisFuncionario;
import br.com.folha.facade.TipoRaisFuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoRaisFuncionario.class,value="tipoRaisFuncionarioConverter")
public class TipoRaisFuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoRaisFuncionarioFacade facade = FacadeLocator.getService(TipoRaisFuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoRaisFuncionario tipoRaisFuncionario = (TipoRaisFuncionario)arg2;
	    return String.valueOf(tipoRaisFuncionario.getId());
	  }
}
