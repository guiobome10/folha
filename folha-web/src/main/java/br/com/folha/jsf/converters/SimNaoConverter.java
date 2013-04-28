package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="simNaoConverter")
public class SimNaoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		return newvalue.equals("Sim") ? true : false;
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object arg2) {
    	return (Boolean)arg2 ? "Sim" : "Não";
  }	    
}
