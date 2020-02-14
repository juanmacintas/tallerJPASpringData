package es.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;

import es.biblioteca.entity.Editorial;

@DataJpaTest
@DBRider
@DisplayName("JUnit Test unitario repositorio Editorial")
public class EditorialRepositoryTest {

	@Autowired
	EditorialRepository editorialRepository;


	@Test
	@DataSet(value = "editoriales.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<Editorial> editoriales = editorialRepository.findAll();

		  assertEquals(editoriales.size(), 11);
	}


	@Test
	@DataSet(value = "editoriales.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<Editorial> editorial = editorialRepository.findById(5);

		  assertEquals(editorial.isPresent(), true);
		  assertEquals(editorial.get().getNombre(),"Minotauro");

	}


	@Test
	@DataSet(value = "editoriales.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar por nombre editorial")
	public void testFindNombre() {

		  List<Editorial> editoriales = editorialRepository.findByNombreEndsWith("BOOKS");

		  assertEquals(editoriales.size(), 2);

		  editoriales = editorialRepository.findNativeByNombreEndsWith("BOOKS");

		  assertEquals(editoriales.size(), 2);

	}

	@Test
	@DataSet(value = "editoriales.yml", cleanBefore = true, cleanAfter = true)
	@DisplayName("Test unitario buscar por nombre editorial named parameter")
	public void testFindNombreNamedParameter() {

		  Editorial editorial = editorialRepository.findNamedParameterByName("Minotauro");

		  assertEquals(editorial.getId(), 5);


	}

}
