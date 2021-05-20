package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long>{

	@Autowired
	private AutorRepository autorRepository; 
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Optional<?> instance;
		if(value!= null) {
			instance = autorRepository.findById(value);
			return false;
		}
		
		return true;
	}

}
