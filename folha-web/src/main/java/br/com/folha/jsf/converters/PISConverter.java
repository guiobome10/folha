package br.com.folha.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.inputmask.InputMask;

@FacesConverter(value="pisConverter")
public class PISConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		StringBuilder builder = new StringBuilder(newvalue);

	    //Caracteres permitidos '0..9 e '-' 

	    boolean encontrouCaracterInvalido = false;
	    int i = 0;
	    while ( i < builder.length() && !encontrouCaracterInvalido) {
	      char c = builder.charAt(i);
	      if (Character.isDigit(c))
	        i++;
	      else
	          if (Character.isDefined('-'))
	            builder.deleteCharAt(i);
	          else 
	            encontrouCaracterInvalido = true;
	    }
	    if (encontrouCaracterInvalido) {
	      FacesMessage message = new FacesMessage("Ocorreu um erro de conversão. ","PIS inválido");
	      message.setSeverity(FacesMessage.SEVERITY_ERROR);
	      throw new ConverterException(message);
	    }
	    return builder.toString();
	  }

	@Override
	public String getAsString(FacesContext facesContext, UIComponent componente, Object value) {
		//11111111111
	    //1111111111-1 - como será exibido
	    String v = value.toString();
	    String mask = "";
	    if(v.isEmpty()){
	    	return v;
	    }
	    if(componente.getClass().equals(InputMask.class)){
	    	InputMask inputMask = (InputMask) componente;
	    	mask = inputMask.getMask();
	    }
	    StringBuilder builder = new StringBuilder();
	    int tam = v.length();
	    int pos = 0;
	    for(int i = tam -1; i >= 0; i--) {
	    	if (pos == 1){
	    		builder.append("-");
	    	}
	        builder.append(v.charAt(i));
	        pos++;
	    }

	    //Se o tamanho da string estiver menor que o tamanho da máscara coloca zeros a esquerda.
	    for(int i = builder.length(); i < mask.length(); i++){
	    	builder.append("0");
	    }
	    builder.reverse();
	    return builder.toString();
	  }
}
