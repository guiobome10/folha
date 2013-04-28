package br.com.folha.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="tituloConverter")
public class TituloConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		StringBuilder builder = new StringBuilder(newvalue);

	    //Caracteres permitidos '0..9 e ' ' 

	    boolean encontrouCaracterInvalido = false;
	    int i = 0;
	    while ( i < builder.length() && !encontrouCaracterInvalido) {
	      char c = builder.charAt(i);
	      if (Character.isDigit(c))
	        i++;
	      else
	          if (Character.isDefined(' '))
	            builder.deleteCharAt(i);
	          else 
	            encontrouCaracterInvalido = true;
	    }
	    if (encontrouCaracterInvalido) {
	      FacesMessage message = new FacesMessage("Ocorreu um erro de conversão. ","Número t�tulo eleitor inválido");
	      message.setSeverity(FacesMessage.SEVERITY_ERROR);
	      throw new ConverterException(message);
	    }
	    return builder.toString();
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		//999999999999
	    //9999 9999 9999 - como será exibido
	    String v = arg2.toString();
	    StringBuilder builder = new StringBuilder();
	    int tam = v.length();
	    for(int i = tam -1; i >= 0; i--) {
	        builder.append(v.charAt(i));
	    }
	    for(int a = builder.length(); a < 12; a++ ){
	    	builder.append("0");
	    }
	    builder.reverse();

	    for(int b = 0; b < 12; b++){
	    	if(b == 4 || b == 8)
	    		builder.append(" ");
	    }
	    
	    return builder.toString();
	  }
}
