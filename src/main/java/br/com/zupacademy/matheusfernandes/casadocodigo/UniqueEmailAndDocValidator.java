package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.zupacademy.matheusfernandes.casadocodigo.cliente.ClienteRepository;

public class UniqueEmailAndDocValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<?> instance;
		if (value.contains("@")) {
			instance = clienteRepository.findByEmail(value);
		} else {
			instance = clienteRepository.findByDocumento(value);
		}
		
		if (instance.isEmpty()) {
			return true;
		}
		return false;
	}

}
