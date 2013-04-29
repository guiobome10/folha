package br.com.folha.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Id;

import br.com.folha.enuns.TipoException;
import br.com.folha.enuns.TipoOperacao;
import br.com.folha.exception.AppException;

public class TrataErro {
	
	
	public static void trataParametroNull(Object t) throws AppException {
		if (t == null) {
			throw new AppException(
					"Parametro nulo não é permitido para este método",
					TipoException.ERROR);
		}
	}

	public static void trataParametroNull(Object t, TipoOperacao tipoOperacao)
			throws AppException {
		if (t == null) {
			throw new AppException(
					"Parametro nulo não é permitido para a operação de "
							+ tipoOperacao.getValue(), TipoException.ERROR);
		}
	}
	
	public static void trataParametroComIdNullOuZero(Object o, TipoOperacao tipoOperacao) throws AppException{
		Field fieldComAnotacaoId = getCampoComAnotacaoId(o);
		Method metodo = getMetodoQueRetornaChaveDaEntidade(o);
		fieldComAnotacaoId.getName();
		fieldComAnotacaoId.getType().getName().endsWith("Long");
		fieldComAnotacaoId.getType().getName().endsWith("Integer");
		fieldComAnotacaoId.getType().getName().endsWith("int");
		fieldComAnotacaoId.getType().getName().endsWith("long");
		fieldComAnotacaoId.getType().getName().endsWith("String");
		try {
			Long id = new Long(0);
			metodo.invoke(o, id);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new AppException("Parametro com Id nulo não é permitido para a operação de " + tipoOperacao.getValue(), TipoException.ERROR);
	}
	
	public static Field getCampoComAnotacaoId(Object o) throws AppException{
		Field[] fields = o.getClass().getDeclaredFields();
		Field fieldComAnotacaoId = null;
		for(int i = 0; i < fields.length; i++){
			if(fields[i].isAnnotationPresent(Id.class)){
				fieldComAnotacaoId = fields[i];
			}
		}
		if(fieldComAnotacaoId == null){
			throw new AppException("A classe do objeto passado como parametro não possui a anota��o @Id.", TipoException.ERROR);
		}
		return fieldComAnotacaoId;
	}

	public static Method getMetodoQueRetornaChaveDaEntidade(Object o) throws AppException{
		Method[] methods = o.getClass().getDeclaredMethods();
		Method metodoQueRetornaChaveDaEntidade = null;
		String campoComAnotacaoId = getCampoComAnotacaoId(o).getName();
		for(int i = 0; i < methods.length; i++){
			if(methods[i].getName().contains("get")){
				int index = methods[i].getName().indexOf("get");
				String methodName = methods[i].getName().substring(index+3);
				if(methodName.equalsIgnoreCase(campoComAnotacaoId)){
					metodoQueRetornaChaveDaEntidade = methods[i];
				}
			}
		}
		return metodoQueRetornaChaveDaEntidade;
	}
	
	public static void trataIdZerado(Long id) throws AppException{
		if(id.equals(new Long(0)))
			throw new AppException("Id zerado não é permitido para essa operação.", TipoException.ERROR);
	}

	public static void trataIdZerado(Long id, TipoOperacao tipoOperacao) throws AppException{
		if(id.equals(new Long(0)))
			throw new AppException("Id zerado não é permitido para a operação de" + tipoOperacao.getValue(), TipoException.ERROR);
	}
	
	public static void trataParametroVazio(String parametro) throws AppException{
		if(parametro.trim().isEmpty())
			throw new AppException("Paramêtro vazio não é permitido para essa operação.", TipoException.ERROR);
	}
	
	public static void trataParametroVazio(String parametro, TipoOperacao tipoOperacao) throws AppException{
		if(parametro.trim().isEmpty())
			throw new AppException("Paramêtro vazio não é permitido para a operação de" + tipoOperacao.getValue(), TipoException.ERROR);
	}
	
}
