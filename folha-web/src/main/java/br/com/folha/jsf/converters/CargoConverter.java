package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Cargo;
import br.com.folha.facade.CargoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Cargo.class,value="cargoConverter")
public class CargoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			CargoFacade facade = FacadeLocator.getService(CargoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Cargo cargo = (Cargo)arg2;
	    return String.valueOf(cargo.getId());
	  }
}
