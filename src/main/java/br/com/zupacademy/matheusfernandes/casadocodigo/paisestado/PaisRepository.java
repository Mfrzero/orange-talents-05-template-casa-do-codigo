package br.com.zupacademy.matheusfernandes.casadocodigo.paisestado;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaisRepository extends CrudRepository<Pais, Long>{

	Optional<?> findByNome(String nome);

}
