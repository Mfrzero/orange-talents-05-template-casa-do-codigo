package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHandler {
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public List<ErrorHandlerDto> handle(MethodArgumentNotValidException e) {
		List<ErrorHandlerDto> dto = new ArrayList<>();
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		fieldErrors.forEach(ex -> {
			String mensagem = messageSource.getMessage(ex, LocaleContextHolder.getLocale());
			ErrorHandlerDto erro = new ErrorHandlerDto(ex.getField(), mensagem);
			dto.add(erro);
		});
		return dto;
	}
}
