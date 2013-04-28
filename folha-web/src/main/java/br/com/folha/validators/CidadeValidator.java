package br.com.folha.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.folha.entity.Cidade;

@FacesValidator(value="cidadeValidator")
public class CidadeValidator implements Validator {
     @Override
     public void validate(FacesContext arg0, UIComponent arg1, Object valorTela) throws ValidatorException {
         if(valorTela == null || String.valueOf(valorTela).isEmpty()){ 
        	 return;
         }
         Cidade cidade = (Cidade) valorTela;
    	 if (cidade.getId() == null || cidade.getId().equals(new Long(0))) {
               FacesMessage message = new FacesMessage();
               message.setSeverity(FacesMessage.SEVERITY_ERROR);
               message.setSummary("Erro na validação do cpf. Verifique o cpf digitado.");
               throw new ValidatorException(message);
          }
     }
}