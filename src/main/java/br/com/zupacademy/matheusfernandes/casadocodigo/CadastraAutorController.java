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
	
	@GetMapping(value = "/lista")
	public List<Autor> lista(){
		Iterable<Autor> autor = autorRepository.findAll();
		return (List<Autor>) autor;
	}
	
	@PostMapping(value = "/cadastraAutor")
	public ResponseEntity<Autor> criaAutor(@RequestBody @Valid AutorForm autorForm) {
		
		if (autorForm.getNome().isBlank() || autorForm.getEmail().isBlank() || autorForm.getDescricao().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		
		Autor autor = autorForm.converter(autorRepository);
		
		System.out.println("Criando autor...");
		
		autorRepository.save(autor);
		autorForm.toString();
		return ResponseEntity.ok().build();
		
	}
	

	
}
