package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.inputmask.InputMask;

@FacesConverter(value="numericMaskedConverter")
public class NumericConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		return Long.parseLong(newvalue);
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object arg2) {
	    String v = arg2.toString();
	    String mask = "";
	    if(v.isEmpty()){
	    	return v;
	    }
	    if(componente.getClass().equals(InputMask.class)){
	    	InputMask inputMask = (InputMask) componente;
	    	mask = inputMask.getMask();
	    }
	    StringBuilder builder = new StringBuilder();
	    for(int a = v.length()-1; a >= 0; a--){
	    	builder.append(v.charAt(a));
	    }
	    //Se o tamanho da string estiver menor que o tamanho da máscara coloca zeros a esquerda.
	    for(int i = builder.length(); i < mask.length(); i++){
	    	builder.append("0");
	    }
	    
	    builder.reverse();
	    return builder.toString();
	  }
	  
	    
}
