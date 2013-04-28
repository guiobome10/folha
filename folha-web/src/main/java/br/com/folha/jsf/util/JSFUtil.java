package br.com.folha.jsf.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.folha.enuns.TipoException;
import br.com.folha.exception.AppException;

public class JSFUtil {

	public static FacesContext getCurrentInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static ExternalContext getExternalContext() {
		return getCurrentInstance().getExternalContext();
	}

	public static String getRequestParameter(String parameterName) {
		Map<String, String> paramMap = getExternalContext()
				.getRequestParameterMap();
		return (String) paramMap.get(parameterName);
	}

	public static Object getRequestAttribute(String attributeName) {
		Map<String, Object> attrMap = getExternalContext().getRequestMap();
		return attrMap.get(attributeName);
	}

	public static Object getSessionAttribute(String attributeName) {
		Map<String, Object> attrMap = getExternalContext().getSessionMap();
		return attrMap.get(attributeName);
	}

	public static void setHttpSessionAttribute(String attributeName,
			Object attribute) {
		HttpSession httpSession = (HttpSession) getExternalContext()
				.getSession(true);
		httpSession.setAttribute(attributeName, attribute);
	}

	public static Object getApplicationAttribute(String attributeName) {
		Map<String, Object> reqAttrMap = getExternalContext()
				.getApplicationMap();
		return reqAttrMap.get(attributeName);
	}

	public static void addGlobalMessage(String message) {
		FacesMessage facesMessage = new FacesMessage(message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addInfoMessage(String message) {
		message = mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addInfoWarning(String message) {
		message = mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_WARN, message, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static void addErrorMessage(String message) {
		message = mensagemComHora(message);
		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_ERROR, message, message);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	}

	public static String getRealPath(String path) {
		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) aFacesContext
				.getExternalContext().getContext();
		String realPath = context.getRealPath(path);
		return realPath;
	}

	public static String mensagemComHora(String msg) {
		return new SimpleDateFormat("HH:mm:ss ").format(new Date()).toString()
				+ msg;
	}

	public static void finalizaSessao() {
		HttpSession httpSession = (HttpSession) getExternalContext()
				.getSession(true);
		httpSession.invalidate();
	}

	public static void trataAppExeption(Exception e) {
		e.printStackTrace();
		if (e instanceof AppException) {
			/*
			 * Trata como AppException
			 */
			if (((AppException) e).getTipoException()
					.equals(TipoException.INFO)) {
				addInfoMessage(e.getMessage());
			}
			if (((AppException) e).getTipoException()
					.equals(TipoException.WARN)) {
				addInfoWarning(e.getMessage());
			}
			if (((AppException) e).getTipoException().equals(
					TipoException.ERROR)) {
				addErrorMessage(e.getMessage());
			}
		} else {
			/*
			 * Lanºa Erro genºrico
			 */
			addErrorMessage("Ocorreu uma falha inesperada no sistema. Erro: "
					+ e.getMessage());
		}
	}

	public static String getRequestURL() {
		Object request = FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		if (request instanceof HttpServletRequest) {
			return ((HttpServletRequest) request).getRequestURL().toString();
		} else {
			return "";
		}
	}
	
	public static String getXmlPath(){
		return getRealPath("resources" + File.separator + "xml");
	}

}
