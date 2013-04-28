package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.inputmask.InputMask;

@FacesConverter(value="valorDecimalConverter")
public class ValorDecimalConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		String valorSemPonto = newvalue.replace(".", "");
		return valorSemPonto.replace(',', '.');
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent componente, Object arg2) {
		//111111.11
	    //111.111,11 - como será exibido
	    String v = arg2.toString();
	    v = v.replace('.', ',');
	    String mask = "";
	    if(v.isEmpty()){
	    	return v;
	    }
	    if(componente.getClass().equals(InputMask.class)){
	    	InputMask inputMask = (InputMask) componente;
	    	mask = inputMask.getMask();
	    	mask = mask.substring(0, mask.indexOf(","));	
	    }
	    String valorAntesDoPonto = v.substring(0, v.indexOf(","));
	    String valorDepoisDoPonto = v.substring(v.indexOf(","));
	    StringBuilder builder = new StringBuilder();
	    int ponto = 0;
	    for(int a = valorAntesDoPonto.length()-1; a >= 0; a--){
	    	if(ponto==3){
	    		ponto = 0;
	    		builder.append(".");
	    	}
	    	builder.append(valorAntesDoPonto.charAt(a));
	    	ponto++;
	    }
	    //Se o tamanho da string estiver menor que o tamanho da máscara coloca zeros a esquerda.
	    for(int i = builder.length(); i < mask.length(); i++){
	    	builder.append(mask.charAt(i)=='.' ? mask.charAt(i) : "0");
	    }
	    
	    builder.reverse();
	    builder.append(valorDepoisDoPonto);
	    return builder.toString();
	    
	  }
	  
	    
}
