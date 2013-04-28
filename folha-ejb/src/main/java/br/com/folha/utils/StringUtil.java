package br.com.folha.utils;


public class StringUtil {
	
	public static String removePontos(String entrada){
		return entrada.replace(".", "");
	}
	
	public static String removeTracos(String entrada){
		return entrada.replace("-", "");
	}
	
	public static String removePontosETracos(String entrada){
		return removePontos(removeTracos(entrada));
	}
}
