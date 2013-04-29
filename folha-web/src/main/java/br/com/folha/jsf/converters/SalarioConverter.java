package br.com.folha.jsf.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="salarioConverter")
public class SalarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		if(!newvalue.isEmpty()){
			String valorSemPonto = newvalue.replace(".", "");
			return BigDecimal.valueOf(Double.valueOf(valorSemPonto.replace(',', '.')));
		}
		return null;
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		//111111.11
	    //11.111.111,11 - como será exibido
	    String v = arg2.toString();
	    v = v.replace('.', ',');
	    StringBuilder builder = new StringBuilder();
	    int tam = v.length();
	    for(int i = 0; i < tam; i++) {
	      if (i == 2 || i== 6)
	        builder.append(".");
	      else
	      if (i == 10)
	    	  builder.append(",");
	      if (i < 12)
	        builder.append(v.charAt(i));
	      else
	        break;
	    }
	    return builder.toString();
	  }
}
