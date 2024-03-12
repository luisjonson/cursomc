package com.treinamento.resources.exeption;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStemp) {
		super(status, msg, timeStemp);
	}

	public List<FieldMessage> getErrors() {
		return erros;
	}

	public void addError(String fielName, String message) {
		erros.add(new FieldMessage(fielName, message));
	}

}
