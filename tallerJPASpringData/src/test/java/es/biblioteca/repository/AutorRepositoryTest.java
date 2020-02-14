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
import org.springframework.data.jpa.domain.Specification;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;

import es.biblioteca.entity.Autor;
import es.biblioteca.specification.AutorSpecification;

@DataJpaTest
@DBRider
@DisplayName("JUnit Test unitario repositorio Autor")
public class AutorRepositoryTest {

	@Autowired
	AutorRepository autorRepository;


	@Test
	@DataSet(value = "autores.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<Autor> autores = autorRepository.findAll();

		  assertEquals(autores.size(), 18);
	}


	@Test
	@DataSet(value = "autorKenFollet.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<Autor> autor = autorRepository.findById(1);

		  assertEquals(autor.isPresent(), true);
		  assertEquals(autor.get().getNombre(),"Ken Follett");

		  Optional<Autor> autorFail = autorRepository.findById(50);

		  assertEquals(autorFail.isPresent(), false);

	}

	@Test
	@DataSet(value = "autores.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario añadir autor")
	public void testAddAutor() {

		  Autor nuevoAutor = Autor.builder()
				  							.id(25)
				  							.nombre("Carlos Sisi")
				  							.build();

		  nuevoAutor = autorRepository.save(nuevoAutor);


		  assertEquals(nuevoAutor.getId(), 25);

		  List<Autor> autores = autorRepository.findAll();
		  assertEquals(autores.size(), 19);
	}

	@Test
	@DataSet(value = "autorKenFollet.yml", disableConstraints = false, cleanBefore = true, cleanAfter = true)
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

	@Test
	@DataSet(value = "autores.yml, categorias.yml, editoriales.yml, libros.yml, autores_libros.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar autores specification  con mas de un libro")
	public void testFindAutorSpecificationMasDeUnLibro() {
		Specification<Autor> specificationAutor = Specification.where(AutorSpecification.filterMasDeUnLibro());

		List<Autor> autores = autorRepository.findAll(specificationAutor);

		 assertEquals(autores.size(),6);

	}

}
