package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.enuns.CodigoRecolhimento;

@FacesConverter(forClass=CodigoRecolhimento.class,value="codigoRecolhimentoConverter")
public class CodigoRecolhimentoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			String chave = newvalue.substring(0, 3);
			return CodigoRecolhimento.valueOf("COD_" + chave);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		CodigoRecolhimento codigoRecolhimento = (CodigoRecolhimento)arg2;
	    return codigoRecolhimento.getDescricaoAbreviada();
	  }
}
