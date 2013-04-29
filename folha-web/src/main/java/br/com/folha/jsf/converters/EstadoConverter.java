package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.folha.entity.Estado;
import br.com.folha.jsf.mb.EstadoMB;

@FacesConverter(forClass=Estado.class,value="estadoConverter")
public class EstadoConverter implements Converter{

	@Inject
	EstadoMB estadoMB;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String sigla) {
		try {
			return estadoMB.getEstadoPorSigla(sigla);
		} catch (Exception e) {
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object estado) {
	    return ((Estado)estado).getSigla();
	  }
}
