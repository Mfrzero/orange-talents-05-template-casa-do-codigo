package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailValidator implements Validator{

	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}
		AutorForm form = (AutorForm) target; 
		Optional<Autor> autorExistente = autorRepository.findByEmail(form.getEmail());
		
		if(autorExistente.isPresent()) {
			errors.rejectValue("email", null, "Email já cadastrado");
		}
	}

}
