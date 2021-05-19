package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, String>{

	private String domainAttribute;
	private Class<?> klass;
	
//	@PersistenceContext
//	private EntityManager manager;
	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void initialize(UniqueValue constraintAnnotation) {
		domainAttribute = constraintAnnotation.fieldName();
		klass = constraintAnnotation.domainClass();
	}
	
//	@Override
//	public boolean isValid(Object value, ConstraintValidatorContext context) {
//		Query query = manager.createQuery("select 1 from" + klass.getName()+" where " + domainAttribute + "=:value");
//		query.setParameter("value", value);
//		List<?> list = query.getResultList();
//		Assert.state(list.size() <= 1, "Foi encontrado mais de um "+ klass+ "com o atributo"+domainAttribute + " = " + value);
//		return list.isEmpty();
//	}

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
