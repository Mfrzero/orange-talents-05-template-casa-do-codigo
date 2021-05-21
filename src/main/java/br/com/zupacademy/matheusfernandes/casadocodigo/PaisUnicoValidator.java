package br.com.zupacademy.matheusfernandes.casadocodigo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zupacademy.matheusfernandes.casadocodigo.paisestado.Pais;

public class PaisUnicoValidator implements ConstraintValidator<PaisUnico, String>{

	@PersistenceContext
	private EntityManager manager;
	private String domainAttribute;
	private Class<?> klass;

	@Override
	public void initialize(PaisUnico params) {
		domainAttribute = params.fieldName();
		klass = params.domainClass();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Pais pais = manager.find(Pais.class, value);
		
		if(value == null || value.isBlank() ) {
			return false;
		}
		return true;
	}

}
