package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoExposicaoFuncionario;
import br.com.folha.facade.TipoExposicaoFuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoExposicaoFuncionario.class,value="tipoExposicaoFuncionarioConverter")
public class TipoExposicaoFuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoExposicaoFuncionarioFacade facade = FacadeLocator.getService(TipoExposicaoFuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoExposicaoFuncionario tipoExposicaoFuncionario = (TipoExposicaoFuncionario)arg2;
	    return String.valueOf(tipoExposicaoFuncionario.getId());
	  }
}
