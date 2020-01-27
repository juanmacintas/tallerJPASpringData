package es.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import es.biblioteca.entity.Autor;

@DataJpaTest
@DisplayName("JUnit Test unitario repositorio Autor")
public class AutorRepositoryTest {

	@Autowired
	AutorRepository autorRepository;


	@Test
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<Autor> autores = autorRepository.findAll();

		  assertEquals(autores.size(), 15);
	}


	@Test
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<Autor> autor = autorRepository.findById(1);

		  assertEquals(autor.isPresent(), true);
		  assertEquals(autor.get().getNombre(),"Ken Follett");

		  Optional<Autor> autorFail = autorRepository.findById(50);

		  assertEquals(autorFail.isPresent(), false);

	}

	@Test
	@DisplayName("Test unitario añadir autor")
	public void testAddAutor() {

		  Autor nuevoAutor = Autor.builder()
				  							.id(15)
				  							.nombre("Carlos Sisi")
				  							.build();

		  nuevoAutor = autorRepository.save(nuevoAutor);


		  assertEquals(nuevoAutor.getId(), 15);

		  List<Autor> autores = autorRepository.findAll();
		  assertEquals(autores.size(), 15);
	}

	@Test
	@DisplayName("Test unitario borrar autor")
	public void testDeleteAutor() {
		DataIntegrityViolationException exception = assertThrows(
		  DataIntegrityViolationException.class,
				() -> {
					autorRepository.deleteById(1);
					autorRepository.flush();
				});

      	assertTrue(exception.getMessage().contains("constraint"));
	}


}
