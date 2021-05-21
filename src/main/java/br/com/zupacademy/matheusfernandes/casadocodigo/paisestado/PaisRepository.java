package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PaisRepository extends CrudRepository<Pais, Long>{

	Optional<?> findByNome(String nome);

}
