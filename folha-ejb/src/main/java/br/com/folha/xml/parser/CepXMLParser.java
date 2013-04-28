package br.com.folha.xml.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.folha.entity.Endereco;

public class CepXMLParser extends DefaultHandler{

	private static final String WEBSERVICE_CEP = "webservicecep";
	private static final String RESULTADO = "resultado";
	private static final String RESULTADO_TXT = "resultado_txt";
	private static final String UF = "uf";
	private static final String CIDADE = "cidade";
	private static final String BAIRRO = "bairro";
	private static final String TIPO_LOGRADOURO = "tipo_logradouro";
	private static final String LOGRADOURO = "logradouro";
	private static StringBuffer newData;
	private static Endereco endereco;
	private static StringBuffer valorAtual = new StringBuffer(50);
	private static File arquivo; 
	
	public CepXMLParser(){
		super();
	}

	public static Endereco getEndereco(String cep, String caminho) throws IOException {
		
		CepXMLParser request = new CepXMLParser();
		// a string da url  
		String urlString = "http://cep.republicavirtual.com.br/web_cep.php";  
		  
		// os parametros a serem enviados  
		Properties parameters = new Properties();  
		parameters.setProperty("cep",cep);  
		parameters.setProperty("formato","xml");  
		  
		// o iterador, para criar a URL  
		Iterator<Object> i = parameters.keySet().iterator();  
		// o contador  
		int counter = 0;  
		  
		// enquanto ainda existir parametros  
		while (i.hasNext()) {  
		    // pega o nome  
		    String name = (String) i.next();  
		    // pega o valor  
		    String value = parameters.getProperty(name);  
		  
		    // adiciona com um conector (? ou &)  
		    // o primeiro é ?, depois são &  
		    urlString += (++counter == 1 ? "?" : "&")  
		        + name  
		        + "="  
		        + value;  
		} 
		
		URL url = new URL(urlString);
		
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
		conexao.setRequestProperty("Request-Method", "GET");
		conexao.setDoInput(true);
		conexao.setDoOutput(false);
		
		conexao.connect();
		
		//abre a conexão para input
		BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
		
		newData = new StringBuffer(10000);
		String s;
		while ( null != (s = br.readLine())){
			newData.append("\n" + s);
		}
		br.close();
		
		arquivo = new File(caminho + File.separator + "cep"+ cep +".xml");
		if (!arquivo.exists()) {
			FileOutputStream fos = new FileOutputStream(arquivo);
			PrintWriter out = new PrintWriter(fos, true);

			// imprime o código resultante
			out.println((new String(newData)).trim());

			// imprime o número do resultado
			// out.println("Resultado: " + conexao.getResponseCode() + "/" +
			// conexao.getResponseMessage() );
			fos.close();
		}
		request.parseXML();
		return endereco;
	}
	
	public void parseXML(){
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser = spf.newSAXParser();
			parser.parse(new FileInputStream(arquivo), this);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void startDocument(){
		//System.out.println("Iniciando a leitura do XML");
	}
	public void endDocument(){
		//System.out.println("Terminou a leitura do XML");
	}
	
	public void startElement(String uri, String localName, String tag, Attributes atributos){
		 
	    //cria um ENDERECO
	    if (tag.equalsIgnoreCase(WEBSERVICE_CEP)){
	        endereco = new Endereco();
	    }
	 
	    //imprime o caminho da tag
	    System.out.println(tag + ":");
	         
	    //se o elemento possui atributos, imprime
	    for (int i=0; i < atributos.getLength(); i++){
	        System.out.print(" " + atributos.getQName(i) + " = " + atributos.getValue(i));
	    }
	 
	}
	
	/** 
	 * Indica que o parser achou o fim de uma tag/elemento.
	 * Este evento fornece o nome do elemento, e também pode
	 * fornecer as informações sobre o namespace.
	 */
	public void endElement(String uri, String localName, String tag)
			throws SAXException {
		//adiciona o contato na lista
		if (tag.equalsIgnoreCase(WEBSERVICE_CEP)){
			System.out.println();
		} 
		//senão, seta os atributos do contato
		else if (tag.equalsIgnoreCase(RESULTADO)){
			endereco.setResultado(Integer.parseInt(valorAtual.toString().trim()));
		} else if (tag.equalsIgnoreCase(RESULTADO_TXT)){
			endereco.setMsgResultado(valorAtual.toString().trim());
		} else if (tag.equalsIgnoreCase(UF)){
			endereco.setUf(valorAtual.toString().trim());
		} else if (tag.equalsIgnoreCase(CIDADE)){
			endereco.setCidade(valorAtual.toString().trim());
		}  else if (tag.equalsIgnoreCase(BAIRRO)){
			endereco.setBairro(valorAtual.toString().trim());
		}  else if (tag.equalsIgnoreCase(TIPO_LOGRADOURO)){
			endereco.setTipoLogradouro(valorAtual.toString().trim());
		}  else if (tag.equalsIgnoreCase(LOGRADOURO)){
			endereco.setLogradouro(valorAtual.toString().trim());
		}
		
		//limpa o valor Atual
		valorAtual.delete(0, valorAtual.length()); 

	}
	
	/**
	 * Indica que o parser achou algum Texto (Informação).
	 */
	public void characters(char[] ch, int start, int length) {
		System.out.println(String.copyValueOf(ch,start,length).trim());
		valorAtual.append(ch,start,length);
	}

}
