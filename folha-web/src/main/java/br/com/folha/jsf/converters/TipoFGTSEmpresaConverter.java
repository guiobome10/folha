package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoFGTSEmpresa;
import br.com.folha.facade.TipoFGTSEmpresaFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoFGTSEmpresa.class,value="tipoFGTSEmpresaConverter")
public class TipoFGTSEmpresaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoFGTSEmpresaFacade facade = FacadeLocator.getService(TipoFGTSEmpresaFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoFGTSEmpresa tipoFGTSEmpresa = (TipoFGTSEmpresa)arg2;
	    return String.valueOf(tipoFGTSEmpresa.getId());
	  }
}
