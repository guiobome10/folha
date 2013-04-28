package br.com.folha.utils;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.folha.enuns.TipoException;
import br.com.folha.exception.AppException;



public class FacadeLocator {

	/*
	 * Variáveis comuns do Service Locator
	 */
	private static InitialContext initialContext;
	public static final String LOCAL = "local";
	public static final String REMOTE = "remote";
	private static final String EARNAME = "java:global/folhaEar/Folha-Pagamento-EJB";

	/**
	 * Método responsável por retornar o nome do ear que foi publicado.
	 * Necessário para realizar o lookUp nos servicos disponibilizados.
	 * @return
	 */
	private static String getEarName() {
		return EARNAME;
	}

	/**
	 * Construtor do Contexto de Inicialização do JNDI do Servidor de Aplicações
	 */
	private static Context getInitialContext() throws NamingException {
		initialContext = new InitialContext();
		return initialContext;
	}

	/**
	 * Recupera o facade publicado no servidor através da interface.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getService(Class<T> t) throws Exception, IllegalArgumentException {
		if(t == null)
			throw new IllegalArgumentException("Null não é um valor valido para obter o facade.");
		Local local = t.getAnnotation(Local.class);
		Remote remote = t.getAnnotation(Remote.class);
		if(local == null && remote == null){
			throw new IllegalArgumentException("A classe passada como argumento não é um EJB Local ou Remoto.");
		}
		try {
			String facade = getEarName() + "/" + t.getSimpleName() + "!" + t.getPackage().getName() +"." + t.getSimpleName();
			return (T) getInitialContext().lookup(facade);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new AppException("Não foi possível execução a operação desejada. Erro: "	+ e.getMessage(), TipoException.ERROR);
		}
	}

}
