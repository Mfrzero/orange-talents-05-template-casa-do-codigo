package br.com.zupacademy.matheusfernandes.casadocodigo.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class AutorController {
	
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
