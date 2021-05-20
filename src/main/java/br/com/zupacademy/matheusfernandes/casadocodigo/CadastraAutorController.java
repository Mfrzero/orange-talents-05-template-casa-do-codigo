package br.com.zupacademy.matheusfernandes.casadocodigo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class CadastraAutorController {
	
	@Autowired
	AutorRepository autorRepository;
	
	@PostMapping(value = "/cadastraAutor")
	public String criaAutor(@RequestBody @Valid AutorForm autorForm) {
		if (autorForm.getNome().isBlank() || autorForm.getEmail().isBlank() || autorForm.getDescricao().isBlank()) {
			return "Dados invalidos";
		}
		Autor autor = new Autor(autorForm.getNome(), autorForm.getEmail(), autorForm.getDescricao());
		autorRepository.save(autor);
		return "Criado com sucesso";
	}
}
