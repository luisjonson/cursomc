package com.treinamento.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.treinamento.domain.enums.TipoCliente;
import com.treinamento.dto.ClienteNewDTO;
import com.treinamento.resources.exeption.FieldMessage;
import com.treinamento.services.validation.utils.BR;


public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert,ClienteNewDTO>{

	@Override
	public void initialize(ClienteInsert ann) {
	}
	
	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext content) {
		List<FieldMessage> list = new ArrayList<>();
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","Cpf invalido"));
		}
		
		if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj","CNPJ invalido"));
		}
		
		for (FieldMessage e : list) {
			content.disableDefaultConstraintViolation();
			content.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		
		return list.isEmpty();
		
	}
}
