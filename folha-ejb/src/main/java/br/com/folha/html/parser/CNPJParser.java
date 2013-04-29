package br.com.folha.html.parser;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

import javax.imageio.stream.FileImageOutputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.folha.entity.Endereco;

public class CNPJParser extends DefaultHandler{

	private static final String WEBSERVICE_CEP = "webservicecep";
	private static final String IMG = "img";
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
	private static File arquivoImagem; 
	private static boolean isCaptcha = false;
	
	public CNPJParser(){
		super();
	}

	public static Endereco getEndereco(String cnpj) throws IOException {
		
		CNPJParser request = new CNPJParser();
		// a string da url  
		String urlString = "http://cnpj.republicavirtual.com.br/web_cep.php";  
		  
		// os parametros a serem enviados  
		Properties parameters = new Properties();  
		parameters.setProperty("cnpj",cnpj);  
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
		
		arquivo = new File("cnpj.xml");
		FileOutputStream fos = new FileOutputStream(arquivo);
		PrintWriter out = new PrintWriter(fos, true);
		
		//imprime o código resultante
		out.println(new String(newData));
		
		//imprime o número do resultado
		//out.println("Resultado: " + conexao.getResponseCode() + "/" + conexao.getResponseMessage() );
		fos.close();
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
	    } else 
	    if(tag.equalsIgnoreCase(IMG)){
	    	System.out.println("Atributos: " + atributos != null ? atributos.toString() : "");
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
		else if (tag.equalsIgnoreCase(IMG) && isCaptcha){
			
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

	public static FileImageOutputStream getCaptcha() throws IOException{
		// a string da url  
		String urlString = "http://www.receita.fazenda.gov.br/PessoaJuridica/CNPJ/cnpjreva/cnpjreva_solicitacao2.asp";  
		String urlBase = "http://www.receita.fazenda.gov.br";  
		URL url = new URL(urlString);
		
		HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
		conexao.setRequestProperty("Request-Method", "GET");
		conexao.setDoInput(true);
		conexao.setDoOutput(false);
		
		conexao.connect();
		
		//abre a conexão para input
		BufferedReader br = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
		newData = new StringBuffer(10000);
		boolean ignoraLinha = false;
		String s;
		while(!(s = br.readLine()).contains("<html>")){
			ignoraLinha = true;
		}
		
		ignoraLinha = false;
		newData.append("\n" + s);
		
		while ( null != (s = br.readLine())){
			if(s.contains("<javascript")) ignoraLinha = true;
			
			if(!ignoraLinha && !s.trim().isEmpty()){
				newData.append("\n" + s);
			}
			
			if(s.contains("</javascript>")) ignoraLinha = false;
			
			if(s.contains("<img") && s.contains("id='imgcaptcha'")){
				int inicio = s.indexOf("src='")+5;
				int fim = s.indexOf("'><br/>");
				String caminho = s.substring(inicio, fim).replace("&amp;", "&");
				URL urlImagem = new URL(urlBase + caminho);
				//Abre conexao para obter a imagem.
				HttpURLConnection con = (HttpURLConnection) urlImagem.openConnection();
				con.setRequestProperty("Request-Method", "GET");
				con.setDoInput(true);
				con.setDoOutput(false);
				con.connect();
				arquivoImagem = new File("captcha.jpeg");
//				BufferedImage img = ((ToolkitImage)Toolkit.getDefaultToolkit().createImage(urlImagem)).getBufferedImage();
				BufferedInputStream stream = new BufferedInputStream(con.getInputStream());
				BufferedOutputStream saida = new BufferedOutputStream(new FileOutputStream(arquivoImagem));
				byte[] a = new byte[2048];
				int numeroDeBytesLidos;
				while((numeroDeBytesLidos = stream.read(a)) > 0){
					saida.write(a, 0, numeroDeBytesLidos);
				}
				saida.flush();
				saida.close();
				stream.close();
//				FileImageOutputStream fios = new FileImageOutputStream(arquivoImagem);
//				ByteArrayOutputStream bos = (ByteArrayOutputStream) con.getOutputStream();
//				fios.write(bos.toByteArray());
//				bos.close();
				return null;
			}
		}
		
		br.close();
		
		arquivo = new File("cnpj.xml");
		FileOutputStream fos = new FileOutputStream(arquivo);
		PrintWriter out = new PrintWriter(fos, true);
		
		//imprime o código resultante
		out.println(new String(newData));
		
		//imprime o número do resultado
		//out.println("Resultado: " + conexao.getResponseCode() + "/" + conexao.getResponseMessage() );
		fos.close();
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		CNPJParser.getCaptcha();
	}
}
