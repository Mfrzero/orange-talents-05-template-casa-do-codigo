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
public class CadastraCategoriaController {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping(value = "/listaCategoria")
	public List<Categoria> lista(){
		Iterable<Categoria> categoria = categoriaRepository.findAll();
		return (List<Categoria>) categoria;
	}
	
	@PostMapping("/cadastroCategoria")
	public ResponseEntity<Categoria> criaCategoria(@RequestBody @Valid CategoriaForm form){
		
		if (form.getNome().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		
		Categoria categoria = form.converter(categoriaRepository);
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().build();
		
	}
	
}
