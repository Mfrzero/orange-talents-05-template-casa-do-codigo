package br.com.zupacademy.matheusfernandes.casadocodigo;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
//@Constraint(validatedBy = {UniqueValueValidator.class})
@Constraint(validatedBy = {UniqueEmailAndDocValidator.class})
@Retention(RUNTIME)
@Target(FIELD)
public @interface UniqueValue {

	String message() default "Campo não pode ser vazio, repetido ou nulo";
	
	Class<?>[] groups() default{};

	Class<? extends Payload>[] payload() default{};
	
	String fieldName();
	
	Class<?> domainClass();

}
