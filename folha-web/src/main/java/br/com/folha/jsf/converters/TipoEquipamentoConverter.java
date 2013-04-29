package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoEquipamento;
import br.com.folha.facade.TipoEquipamentoFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoEquipamento.class,value="tipoEquipamentoConverter")
public class TipoEquipamentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoEquipamentoFacade facade = FacadeLocator.getService(TipoEquipamentoFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoEquipamento tipoEquipamento = (TipoEquipamento)arg2;
	    return String.valueOf(tipoEquipamento.getId());
	  }
}
