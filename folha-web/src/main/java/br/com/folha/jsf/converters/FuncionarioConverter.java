package br.com.folha.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.Funcionario;
import br.com.folha.facade.FuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=Funcionario.class,value="funcionarioConverter")
public class FuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		if(newvalue == null){
			return null;
		}
		try {
			FuncionarioFacade facade = FacadeLocator.getService(FuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
		}
	  }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		if(value == null || value.equals(""))
			return "";
		Funcionario funcionario = (Funcionario)value;
	    return String.valueOf(funcionario.getId());
	  }
}
