package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String>{

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Optional<?> instance;
		
		if(value.contains("@")) {
			instance = autorRepository.findByEmail(value);
		} else {
			instance = categoriaRepository.findByNome(value);
		}
		if (instance.isEmpty()) {
			return true;
		}
		return false;
	}

}
