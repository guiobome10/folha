package br.com.folha.cnpj.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.com.folha.utils.StringUtil;

public class ConsultaCnpj {

	private static final String NUMERO_INSCRICAO = "NÚMERO DE INSCRIÇÃO";
	private boolean isNumeroInscricao;
	private boolean isMatrizFilial;
	private static final String DATA_ABERTURA = "DATA DE ABERTURA";
	private boolean isDataAbertura;
	private static final String NOME_EMPRESARIAL = "NOME EMPRESARIAL";
	private boolean isNomeEmpresarial;
	private static final String NOME_FANTASIA = "TÍTULO DO ESTABELECIMENTO (NOME DE FANTASIA)";
	private boolean isNomeFantasia;
	private static final String CODIGO_DESCRICAO_ATIVIDADE_PRINCIPAL = "CÓDIGO E DESCRIÇÃO DA ATIVIDADE ECONÔMICA PRINCIPAL";
	private boolean isCodigoDescricaoAtividadePrincipal;
	private static final String CODIGO_DESCRICAO_ATIVIDADES_SECUNDARIAS = "CÓDIGO E DESCRIÇÃO DAS ATIVIDADES ECONÔMICAS SECUNDÁRIAS";
	private boolean isCodigoDescricaoAtividadesSecundarias;
	private static final String ATIVIDADE_NAO_INFORMADA = "Não informada";
	private static final String CODIGO_DESCRICAO_NATUREZA_JURIDICA = "CÓDIGO E DESCRIÇÃO DA NATUREZA JURÍDICA";
	private boolean isCodigoDescricaoNaturezaJuridica;
	private static final String LOGRADOURO = "LOGRADOURO";
	private boolean isLogradouro;
	private static final String NUMERO = "NÚMERO"; 
	private static final String SEM_NUMERO = "S/N";
	private boolean isNumero;
	private static final String COMPLEMENTO = "COMPLEMENTO";
	private boolean isComplemento;
	private static final String CEP = "CEP";
	private boolean isCep;
	private static final String BAIRRO = "BAIRRO/DISTRITO";
	private boolean isBairro;
	private static final String MUNICIPIO = "MUNICÍPIO";
	private boolean isMunicipio;
	private static final String UF = "UF";
	private boolean isUf;
	private static final String SITUACAO_CADASTRAL = "SITUAÇÃO CADASTRAL";
	private boolean isSituacaoCadastral;
	private static final String DATA_SITUACAO_CADASTRAL = "DATA DA SITUAÇÃO CADASTRAL";
	private boolean isDataSituacaoCadastral;
	private static final String MOTIVO_SITUACAO_CADASTRAL = "MOTIVO DE SITUAÇÃO CADASTRAL";
	private boolean isMotivoSituacaoCadastral;
	private static final String SITUACAO_ESPECIAL = "SITUAÇÃO ESPECIAL";
	private boolean isSituacaoEspecial;
	private static final String DATA_SITUACAO_ESPECIAL = "DATA DA SITUAÇÃO ESPECIAL";
	private static final String ASTERISCOS = "********";
	private static final String ERRO_CONSULTA = "Erro na Consulta";
	private static final String ERRO_CONSULTA_CNPJ = "Verifique se o mesmo foi digitado corretamente";
	private boolean isDataSituacaoEspecial;
	private static final String FONT = "<font"; 
	private static final String B = "<b>"; 
	private static final String fechaB = "</b>"; 
	private boolean ultimaTagFont;
	private static SimpleDateFormat br = new SimpleDateFormat("dd/MM/yyyy");
	private static EmpresaReceita empresa;
	private static String acumulador;
	private static HttpResponse resposta;
	private static DefaultHttpClient cliente;
	private static HttpContext contexto;
	private static HttpEntity entidade;
	private static InputStream entrada;
	private String viewState;

	public ConsultaCnpj() throws Exception{
//		String strProxyUsername = "";  
//		String strProxyDomain = "tivit";  
//        String strProxyPassword = "";  
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
          
		// Adiciona a autenticação do Proxy
//        cliente.getCredentialsProvider().setCredentials( new AuthScope(proxy),
//				new NTCredentials(strProxyUsername, strProxyPassword, strProxyHost, strProxyDomain));

        // Adicionando um sistema de redireção  
        cliente.setRedirectStrategy(new LaxRedirectStrategy());  
  
        // Mantendo a conexão sempre ativa  
        cliente.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());  
  
        // Criando o container de cookies  
        CookieStore cookie = new BasicCookieStore();  
  
        contexto = new BasicHttpContext();  
  
        // Adicionando o coockie store no contexto de conexão  
        contexto.setAttribute(ClientContext.COOKIE_STORE, cookie);  
  
        // Criando o método de acesso  
        HttpGet requisicaoo1 = new HttpGet("http://www.receita.fazenda.gov.br/PessoaJuridica/CNPJ/cnpjreva/Cnpjreva_Solicitacao2.asp");  
  
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
            	if(linha.indexOf("value='") > 0 && linha.indexOf("'>") > 0){
            		viewState = linha.substring(linha.indexOf("value='") + 7, linha.indexOf("'>"));
            	}
            }
        }  
	}
	
	public EmpresaReceita consultarCnpj(String cnpj, String captcha) throws Exception {
		
        // Criando o método de acesso  
        HttpPost requisicao3 = new HttpPost("http://www.receita.fazenda.gov.br/pessoajuridica/cnpj/cnpjreva/valida.asp");  
  
        // Lista de parâmetros  
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
  
        // Adicionando os parâmetros  
        nameValuePairs.add(new BasicNameValuePair("origem", "comprovante"));  
        nameValuePairs.add(new BasicNameValuePair("search_type", "cnpj"));  
        nameValuePairs.add(new BasicNameValuePair("cnpj", cnpj));  
        nameValuePairs.add(new BasicNameValuePair("captcha", captcha));  
        nameValuePairs.add(new BasicNameValuePair("captchaAudio", ""));
        nameValuePairs.add(new BasicNameValuePair("submit1", "Consultar"));  
        nameValuePairs.add(new BasicNameValuePair("viewstate", viewState));  
  
        // Encapsulando  
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");  
  
        // A adição dos parâmetros  
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
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada));  
  
        empresa = new EmpresaReceita();
        String linha = "";
		// Para cada linha  
        while ((linha  = bufferedReader.readLine()) != null) {  
            // Escreva  
            //System.out.println(linha);  
            //trata Resposta.
            trataResposta(linha);
        }  
  
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  
//        
//        System.out.println(empresa);
        return empresa;
	}

	private void trataResposta(String linha) throws ParseException, Exception {

		//Numero inscricao e se é matriz ou filial
		if(isMatrizFilial && linha.contains(B)){
			empresa.setMatrizFilial(getValorTag(linha));
			isMatrizFilial = false;
		}
		if(isNumeroInscricao && ultimaTagFont && linha.contains(B)){
			empresa.setCnpj(getValorTag(linha)
					.replace(".","").replace("/", "").replace("-", ""));
			isMatrizFilial = true;
			isNumeroInscricao = false;
		}
		if(linha.contains(NUMERO_INSCRICAO) && ultimaTagFont){
			isNumeroInscricao = true;
		}

		//Data de abertura da empresa.
		if(isDataAbertura && ultimaTagFont && linha.contains(B)){
			empresa.setDataAbertura(br.parse(getValorTag(linha)));
			isDataAbertura = false;
		}
		if(linha.contains(DATA_ABERTURA) && ultimaTagFont){
			isDataAbertura = true;
		}

		//Nome empresarial - Razão social
		if(isNomeEmpresarial && ultimaTagFont && linha.contains(B)){
			empresa.setNomeEmpresarial(getValorTag(linha));
			isNomeEmpresarial = false;
		}
		if(linha.contains(NOME_EMPRESARIAL) && ultimaTagFont){
			isNomeEmpresarial = true;
		}
		
		//Nome fantasia
		if(isNomeFantasia && ultimaTagFont && linha.contains(B)){
			empresa.setNomeFantasia(getValorTag(linha));
			isNomeFantasia = false;
		}
		if(linha.contains(NOME_FANTASIA) && ultimaTagFont){
			isNomeFantasia = true;
		}

		//Código e descrição da atividade principal da empresa
		if(isCodigoDescricaoAtividadePrincipal && ultimaTagFont && linha.contains(B)){
			String[] vetor = getValorTag(linha).split(" - ");
			empresa.setCodigoAtividadePrincipal(StringUtil.removePontosETracos(vetor[0]));
			empresa.setDescricaoAtividadePrincipal(vetor[1]);
			isCodigoDescricaoAtividadePrincipal = false;
		}
		if(linha.contains(CODIGO_DESCRICAO_ATIVIDADE_PRINCIPAL) && ultimaTagFont){
			isCodigoDescricaoAtividadePrincipal = true;
		}
		
		//Códigos e descrições das atividades secundarias.
		if(isCodigoDescricaoAtividadesSecundarias && ultimaTagFont && linha.contains(B)){
			if(linha.contains(ATIVIDADE_NAO_INFORMADA)){
				empresa.getCodigosAtividadesSecundarias().add("0000000");
				empresa.getDescricoesAtividadesSecundarias().add(getValorTag(linha));	
			}else{
				String[] vetor = getValorTag(linha).split(" - ");
				empresa.getCodigosAtividadesSecundarias().add(StringUtil.removePontosETracos(vetor[0]));
				empresa.getDescricoesAtividadesSecundarias().add(vetor[1]);
			}
		}
		if(linha.contains(CODIGO_DESCRICAO_ATIVIDADES_SECUNDARIAS) && ultimaTagFont){
			isCodigoDescricaoAtividadesSecundarias = true;
			empresa.setCodigosAtividadesSecundarias(new ArrayList<String>());
			empresa.setDescricoesAtividadesSecundarias(new ArrayList<String>());
		}
		if(linha.contains("</td>") && isCodigoDescricaoAtividadesSecundarias){
			isCodigoDescricaoAtividadesSecundarias = false;
		}
		
		//Código e descrição da natureza jurídica.
		if(isCodigoDescricaoNaturezaJuridica && ultimaTagFont && linha.contains(B)){
			String[] vetor = getValorTag(linha).split(" - ");
			empresa.setCodigoNaturezaJuridica(StringUtil.removeTracos(vetor[0]));
			empresa.setDescricaoNaturezaJuridica(vetor[1]);
			isCodigoDescricaoNaturezaJuridica = false;
		}
		if(linha.contains(CODIGO_DESCRICAO_NATUREZA_JURIDICA) && ultimaTagFont){
			isCodigoDescricaoNaturezaJuridica = true;
		}
		
		//Logradouro do endereço da empresa
		if(isLogradouro && ultimaTagFont && linha.contains(B)){
			empresa.setLogradouro(getValorTag(linha));
			isLogradouro = false;
		}
		if(linha.contains(LOGRADOURO) && ultimaTagFont){
			isLogradouro = true;
		}
		
		//Número do endereço da empresa
		if(isNumero && ultimaTagFont && linha.contains(B)){
			if(getValorTag(linha).equals(SEM_NUMERO)){
				empresa.setNumero(new Integer(0));
			}else{
				empresa.setNumero(Integer.parseInt(getValorTag(linha)));
			}
			isNumero = false;
		}
		if(linha.endsWith(NUMERO) && ultimaTagFont){
			isNumero = true;
		}
		
		//Complemento do endereço da empresa
		if(isComplemento && ultimaTagFont && linha.contains(B)){
			empresa.setComplemento(getValorTag(linha));
			isComplemento = false;
		}
		if(linha.contains(COMPLEMENTO) && ultimaTagFont){
			isComplemento = true;
		}
		
		//Cep do endereço da empresa
		if(isCep && ultimaTagFont && linha.contains(B)){
			empresa.setCep(StringUtil.removePontosETracos(getValorTag(linha)));
			isCep = false;
		}
		if(linha.contains(CEP) && ultimaTagFont){
			isCep = true;
		}
		
		//Bairro do endereço da empresa
		if(isBairro && ultimaTagFont && linha.contains(B)){
			empresa.setBairro(getValorTag(linha));
			isBairro = false;
		}
		if(linha.contains(BAIRRO) && ultimaTagFont){
			isBairro = true;
		}
		
		//Município do endereço da empresa
		if(isMunicipio && ultimaTagFont && linha.contains(B)){
			empresa.setMunicipio(getValorTag(linha));
			isMunicipio = false;
		}
		if(linha.contains(MUNICIPIO) && ultimaTagFont){
			isMunicipio = true;
		}
		
		//Município do endereço da empresa
		if(isUf && ultimaTagFont && linha.contains(B)){
			empresa.setUf(getValorTag(linha));
			isUf = false;
		}
		if(linha.contains(UF) && ultimaTagFont){
			isUf = true;
		}
		
		//Situacao cadastral da empresa
		if(isSituacaoCadastral && ultimaTagFont && linha.contains(B)){
			empresa.setSituacaoCadastral(getValorTag(linha));
			isSituacaoCadastral = false;
		}
		if(linha.contains(SITUACAO_CADASTRAL) && ultimaTagFont){
			isSituacaoCadastral = true;
		}
		
		//Data da Situacao cadastral da empresa
		if(isDataSituacaoCadastral && ultimaTagFont && linha.contains(B)){
			empresa.setDataSituacaoCadastral(br.parse(getValorTag(linha)));
			isDataSituacaoCadastral = false;
		}
		if(linha.contains(DATA_SITUACAO_CADASTRAL) && ultimaTagFont){
			isDataSituacaoCadastral = true;
		}
		
		//Motivo da Situacao cadastral da empresa
		if(isMotivoSituacaoCadastral && ultimaTagFont && linha.contains(B)){
			empresa.setMotivoSituacaoCadastral(getValorTag(linha));
			isMotivoSituacaoCadastral = false;
		}
		if(linha.contains(MOTIVO_SITUACAO_CADASTRAL) && ultimaTagFont){
			isMotivoSituacaoCadastral = true;
		}
		
		//Situacao Especial da empresa
		if(isSituacaoEspecial && ultimaTagFont && linha.contains(B)){
			empresa.setSituacaoEspecial(getValorTag(linha));
			isSituacaoEspecial = false;
		}
		if(linha.contains(SITUACAO_ESPECIAL) && ultimaTagFont){
			isSituacaoEspecial = true;
		}
		
		//Situacao Especial da empresa
		if(isDataSituacaoEspecial && ultimaTagFont && linha.contains(B)){
			if(!linha.contains(ASTERISCOS)){
				empresa.setDataSituacaoEspecial(br.parse(getValorTag(linha)));
			}
			isDataSituacaoEspecial = false;
		}
		if(linha.contains(DATA_SITUACAO_ESPECIAL) && ultimaTagFont){
			isDataSituacaoEspecial = true;
		}
		
		if(linha.contains(ERRO_CONSULTA)){
			throw new Exception("Caracteres informados não correspondem a imagem.");
		}
		
		if(linha.contains(ERRO_CONSULTA_CNPJ)){
			throw new Exception("CNPJ informado não cadastrado na base de dados receita federal ou inválido. " + ERRO_CONSULTA_CNPJ);
		}
		
		ultimaTagFont = linha.contains(FONT);
	}

	private static String getValorTag(String linha) {
		return linha.substring(linha.indexOf(B)+3,linha.indexOf(fechaB)).replace("\t", "");
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
  
        ByteArrayOutputStream out = null;  
        try {
        	InputStream in = new BufferedInputStream(entrada);
            out = new ByteArrayOutputStream();  
            byte[] buf = new byte[1024];  
            int n = 0;  
            while (-1 != (n = in.read(buf))) {  
                out.write(buf, 0, n);  
            }  
        } finally {
        	if(out != null){
        		out.close();  
        	}
        }
         
        String caminho = ((ServletContext)(facesContext.getExternalContext().getContext())).getRealPath("resources"+ File.separator +"img");
        String captchaFileName = "captchaCnpj"+ (int)(Math.random() * 100) +".jpeg";
        String imagePath = caminho + File.separator + captchaFileName;
        byte[] response = out.toByteArray();  
        try (FileOutputStream fos = new FileOutputStream(imagePath)) {  
            fos.write(response);
            fos.close();
        }  
        
        // Separador  
//        System.out.println();  
//        System.out.println("---------------------------------------------------------");  
//        System.out.println();  

//        captcha = JOptionPane.showInputDialog("Entre com o captcha:");  
        return captchaFileName;
	}

}
