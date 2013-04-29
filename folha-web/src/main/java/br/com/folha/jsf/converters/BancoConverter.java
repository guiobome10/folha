package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Banco;
import br.com.folha.facade.BancoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Banco.class,value="bancoConverter")
public class BancoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			BancoFacade facade = FacadeLocator.getService(BancoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Banco banco = (Banco)arg2;
	    return String.valueOf(banco.getCodigo());
	  }
}
