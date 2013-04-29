package br.com.folha.facade.imp;

import java.io.IOException;

import javax.ejb.Stateless;

import br.com.folha.entity.Endereco;
import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;
import br.com.folha.facade.EnderecoFacade;
import br.com.folha.utils.TrataErro;
import br.com.folha.xml.parser.CepXMLParser;

@Stateless(name="EnderecoFacade")
public class EnderecoFacadeImp implements EnderecoFacade {

	@Override
	public Endereco consultarCep(String cep, String caminho) throws AppException {
		TrataErro.trataParametroNull(cep, TipoOperacao.CONSULTA);
		TrataErro.trataParametroVazio(cep, TipoOperacao.CONSULTA);
		try {
			return CepXMLParser.getEndereco(cep, caminho);
		} catch (IOException e) {
			throw new AppException(e.getMessage(), TipoException.ERROR);
		}
	}
	
}
