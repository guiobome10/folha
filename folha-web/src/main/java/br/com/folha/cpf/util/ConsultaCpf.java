package br.com.folha.cpf.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;


public class ConsultaCpf {

	private static final String CPF = "CPF: ";
	private static final String NOME_PESSOA_FISICA = "Nome da Pessoa F�sica: ";
	private static final String SITUACAO_CADASTRAL = "Situa��o Cadastral: ";
	private static final String DIGITO_VERIFICADOR = "Digito Verificador: ";
	private static final String CONTEUDO_DADOS = "clConteudoDados"; 
	private static final String CONTEUDO_ERRO = "clConteudoCompBold"; 
	private static final String ID_ERRO = "idMensagemErro"; 
	private static final String SPAN_ERRO = "<span class='tituloFieldset fcr'>"; 
	private static boolean erro;
	private static final String FECHA_SPAN = "</span>"; 
	private static PessoaFisica pessoaFisica;
	private static String acumulador;
	private static HttpResponse resposta;
	private static DefaultHttpClient cliente;
	private static HttpContext contexto;
	private static HttpEntity entidade;
	private static InputStream entrada;
	private String viewState;

	public ConsultaCpf() throws Exception{
//		String strProxyUsername = "guilherme.costa";  
//		String strProxyDomain = "tivit";  
//        String strProxyPassword = "!@#MARgui";  
//        String strProxyHost = "10.0.11.10";  
//        String strProxyPort = "8080";  
//        //set up system properties to indicate we are using a proxy  
//        System.setProperty("https.proxyHost", strProxyHost);  
//        System.setProperty("https.proxyPort", strProxyPort);  
//        System.setProperty("proxyHost", strProxyHost);  
//        System.setProperty("proxyPort", strProxyPort);  
//        System.setProperty("proxySet", "true");  
//        System.setProperty("http.proxyHost", strProxyHost);  
//        System.setProperty("http.proxyPort", strProxyPort);  
//        System.setProperty("http.proxySet", "true");      

	    cliente = new DefaultHttpClient();
        
        // Registra o schema que autentica no CIFS
//        cliente.getAuthSchemes().register("ntlm", new NTLMSchemeFactory());
        
//        HttpHost proxy = new HttpHost(strProxyHost, Integer.valueOf(strProxyPort));
//        cliente.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
          
		// Adiciona a autentica��o do Proxy
//        cliente.getCredentialsProvider().setCredentials( new AuthScope(proxy),
//				new NTCredentials(strProxyUsername, strProxyPassword, strProxyHost, strProxyDomain));

        // Adicionando um sistema de redire��o  
        cliente.setRedirectStrategy(new LaxRedirectStrategy());  
  
        // Mantendo a conexão sempre ativa  
        cliente.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());  
  
        // Criando o container de cookies  
        CookieStore cookie = new BasicCookieStore();  
  
        contexto = new BasicHttpContext();  
  
        // Adicionando o coockie store no contexto de conexão  
        contexto.setAttribute(ClientContext.COOKIE_STORE, cookie);  
  
        // Criando o método de acesso  
        HttpGet requisicaoo1 = new HttpGet("http://www.receita.fazenda.gov.br/Aplicacoes/ATCTA/cpf/ConsultaPublica.asp");  
  
        resposta = cliente.execute(requisicaoo1, contexto);  
  
//        // Escrever informações  
//        System.out.println("Status Line: " + resposta.getStatusLine());  
//  
//        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
  
        entidade = resposta.getEntity();  
  
//        // Escrever informações  
//        System.out.println("Encoding: " + entidade.getContentEncoding());  
//        System.out.println("Tamanho: " + entidade.getContentLength());  
//        System.out.println("Tipo: " + entidade.getContentType());  
//  
//        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
  
        entrada = entidade.getContent();  
  
        // Cria um stream de leitura  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada, "ISO-8859-1"));  
  
        // Cria o receptor de linha  
        String linha;  
          
        acumulador = "";  
        viewState = "";
  
        // Para cada linha  
        while ((linha = bufferedReader.readLine()) != null) {  
            // Escreva  
//            System.out.println(linha);  
            acumulador += "\n" + linha;  
            if(linha.contains("id=viewstate")){
            	if(linha.indexOf("name=viewstate value='") > 0 && linha.indexOf("'>") > 0){
            		viewState = linha.substring(linha.indexOf("name=viewstate value='") + 22, linha.lastIndexOf("'>"));
            	}
            }
        }  
	}
	
	public PessoaFisica consultarCpf(String cpf, String captcha) throws Exception {
		
        // Criando o método de acesso  
        HttpPost requisicao3 = new HttpPost("http://www.receita.fazenda.gov.br/Aplicacoes/ATCTA/CPF/ConsultaPublicaExibir.asp");  
  
        // Lista de par�metros  
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
  
        // Adicionando os par�metros  
//        nameValuePairs.add(new BasicNameValuePair("origem", "comprovante"));  
//        nameValuePairs.add(new BasicNameValuePair("search_type", "cpf"));  
        nameValuePairs.add(new BasicNameValuePair("txtCPF", cpf));  
        nameValuePairs.add(new BasicNameValuePair("captcha", captcha));  
        nameValuePairs.add(new BasicNameValuePair("captchaAudio", ""));
//        nameValuePairs.add(new BasicNameValuePair("submit1", "Consultar"));  
        nameValuePairs.add(new BasicNameValuePair("viewstate", viewState));  
  
        // Encapsulando  
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");  
  
        // A adi��o dos par�metros  
        requisicao3.setEntity(urlEncodedFormEntity);  
  
        // Resposta  
        resposta = cliente.execute(requisicao3, contexto);  
  
        // Escrever informações  
//        System.out.println("Status Line: " + resposta.getStatusLine());  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
//  
        // Buscando a entidade  
        entidade = resposta.getEntity();  
  
        // Escrever informações  
//        System.out.println("Encoding: " + entidade.getContentEncoding());  
//        System.out.println("Tamanho: " + entidade.getContentLength());  
//        System.out.println("Tipo: " + entidade.getContentType());  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
  
        // Baixar o stream  
        entrada = entidade.getContent();  
  
        // Cria um stream de leitura  
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada, "ISO-8859-1"));  
  
        pessoaFisica = new PessoaFisica();
        String linha = "";
		// Para cada linha  
        while ((linha  = bufferedReader.readLine()) != null) {  
            // Escreva  
//            System.out.println(linha);  
            //trata Resposta.
            trataResposta(linha);
        }  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
//        
//        System.out.println(empresa);
        bufferedReader.close();
        return pessoaFisica;
	}

	private void trataResposta(String linha) throws Exception{
		if(linha.contains(CONTEUDO_DADOS)){
			if(linha.contains(CPF)){
				pessoaFisica.setCpf(getValorTag(linha, CPF).replace(".", "").replace("-", ""));
			}
			if(linha.contains(NOME_PESSOA_FISICA)){
				pessoaFisica.setNome(getValorTag(linha, NOME_PESSOA_FISICA).trim());
			}
			if(linha.contains(SITUACAO_CADASTRAL)){
				pessoaFisica.setSituacaoCadastral(getValorTag(linha, SITUACAO_CADASTRAL));
			}
			if(linha.contains(DIGITO_VERIFICADOR)){
				pessoaFisica.setDigitoVerificador(Integer.parseInt(getValorTag(linha, DIGITO_VERIFICADOR).trim()));
			}
		}
		if(linha.contains(CONTEUDO_ERRO)){
			throw new Exception("CPF não encontrado na receita federal ou inv�lido. Por favor verifique se o cpf foi digitado corretamente.");
		}
		if(erro && linha.contains(SPAN_ERRO)){
			erro = false;
			throw new Exception(linha.substring(linha.indexOf(SPAN_ERRO) + SPAN_ERRO.length(), linha.indexOf(FECHA_SPAN)));
		}
		if(linha.contains(ID_ERRO)){
			erro = true;
		}
	}

	private static String getValorTag(String linha, String campo) {
		return linha.substring(linha.indexOf(campo) + campo.length(),linha.indexOf(FECHA_SPAN)).replace("\t", "");
	}
	
	public String getCaptchaPath(FacesContext facesContext) throws Exception{
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
          
        acumulador = acumulador.substring(acumulador.indexOf("/scripts/captcha/Telerik.Web.UI.WebResource.axd?"));  
          
        acumulador = acumulador.substring(0, acumulador.indexOf("'"));  
          
//        System.out.println(acumulador.replaceAll("amp;", ""));  
          
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
          
        HttpGet requisicao2 = new HttpGet("http://www.receita.fazenda.gov.br"+acumulador.replaceAll("amp;", "").replaceAll("cah", "rca"));  
          
        // Resposta  
        resposta = cliente.execute(requisicao2, contexto);  
  
        // Escrever informações  
//        System.out.println("Status Line: " + resposta.getStatusLine());  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
  
        // Buscando a entidade  
        entidade = resposta.getEntity();  
  
        // Escrever informações  
//        System.out.println("Encoding: " + entidade.getContentEncoding());  
//        System.out.println("Tamanho: " + entidade.getContentLength());  
//        System.out.println("Tipo: " + entidade.getContentType());  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
  
        // Baixar o stream  
        entrada = entidade.getContent();  
  
        ByteArrayOutputStream out;  
        try (InputStream in = new BufferedInputStream(entrada)) {  
            out = new ByteArrayOutputStream();  
            byte[] buf = new byte[1024];  
            int n = 0;  
            while (-1 != (n = in.read(buf))) {  
                out.write(buf, 0, n);  
            }  
            out.close();  
        }  
         
        String caminho = ((ServletContext)(facesContext.getExternalContext().getContext())).getRealPath("img");
        String captchaFileName = "captchaCpf"+ (int)(Math.random() * 100) +".jpeg";
        byte[] response = out.toByteArray();  
        try (FileOutputStream fos = new FileOutputStream(caminho + File.separator + captchaFileName)) {  
            fos.write(response);
            fos.close();
        }  
        
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  

//        captcha = JOptionPane.showInputDialog("Entre com o captcha:");  
        return "img" + File.separator + captchaFileName;
	}

}
