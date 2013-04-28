package br.com.folha.jsf.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="cnpjConverter")
public class CnpjConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		StringBuilder builder = new StringBuilder(newvalue);

	    //Caracteres permitidos '0..9 '.' e '-' e '/'

	    boolean encontrouCaracterInvalido = false;
	    int i = 0;
	    while ( i < builder.length() && !encontrouCaracterInvalido) {
	      char c = builder.charAt(i);
	      if (Character.isDigit(c))
	        i++;
	      else
	        if (Character.isDefined('.'))
	          builder.deleteCharAt(i);
	        else
	          if (Character.isDefined('-'))
	            builder.deleteCharAt(i);
	          else 
	        	 if(Character.isDefined('/'))
	        		 builder.deleteCharAt(i);
	        	 else
	        		 encontrouCaracterInvalido = true;
	    }
	    if (encontrouCaracterInvalido) {
	      FacesMessage message = new FacesMessage("Ocorreu um erro de conversão. ","CNPJ inv�lido");
	      message.setSeverity(FacesMessage.SEVERITY_ERROR);
	      throw new ConverterException(message);
	    }
	    return builder.toString();
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		//012345678901234
	    //11.111.111/1111-11 - como ser� exibido
	    String v = arg2.toString();
	    StringBuilder builder = new StringBuilder();
	    int tam = v.length();
	    for(int i = 0; i < tam; i++) {
	      if (i == 2 || i== 5)
	        builder.append(".");
	      else
	        if (i == 8)
	          builder.append("/");
	        else
	        	if(i == 12)
	        		builder.append("-");
	      if (i < 14)
	        builder.append(v.charAt(i));
	      else
	        break;
	    }
	    return builder.toString();
	  }
}
