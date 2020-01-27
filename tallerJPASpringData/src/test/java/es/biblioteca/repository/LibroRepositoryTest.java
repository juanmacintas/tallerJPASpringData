package es.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;

import es.biblioteca.entity.Autor;
import es.biblioteca.entity.Libro;

@DataJpaTest
@DisplayName("JUnit Test unitario repositorio Libro")
public class LibroRepositoryTest {

	@Autowired
	LibroRepository libroRepository;


	@Test
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<Libro> libros = libroRepository.findAll();

		  assertEquals(libros.size(),24);
	}


	@Test
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<Libro> libro = libroRepository.findById(1);

		  assertEquals(libro.isPresent(), true);
		  assertEquals(libro.get().getTitulo(),"Los Pilares de la Tierra");

	}

	@Test
	@DisplayName("Test unitario buscar libros favoritos")
	public void testFindFavoritos() {
		  List<Libro> libros = libroRepository.findByFavoriteTrue();

		  assertEquals(libros.size(),5);

	}

	@Test
	@DisplayName("Test unitario buscar libro por titulo")
	public void testFindByTitulo() {
		Optional<Libro> libro = libroRepository.findByTitulo("Los Pilares de la Tierra");

		  assertEquals(libro.isPresent(), true);
		  assertEquals(libro.get().getId(),1);
	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor")
	public void testFindLibrosNombreAutor() {
		  List<Libro> libros = libroRepository.findByAutor_nombre("Ken Follett");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor Ignore Case")
	public void testFindLibrosNombreAutorIgnoreCase() {
		  List<Libro> libros = libroRepository.findByAutor_nombreIgnoreCase("ken follett");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros id de autor")
	public void testFindLibrosIdAutor() {
		  List<Libro> libros = libroRepository.findByAutor_id(1);

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de autor y categoria")
	public void testFindLibrosNombreAutorCateforia() {
		  List<Libro> libros = libroRepository.findByAutor_nombreAndCategoria_nombre("Ken Follett", "Ficción Histórica");

		  assertEquals(libros.size(),3);

		  libros = libroRepository.findByAutor_nombreAndCategoria_nombre("Ken Follett", "Terror");

		  assertEquals(libros.size(),0);


	}

	@Test
	@DisplayName("Test unitario buscar libros nombre de editorial")
	public void testFindLibrosNombreEditorial() {
		  List<Libro> libros = libroRepository.findByEditorial_nombreStartsWith("Planeta");

		  assertEquals(libros.size(),7);

	}

	@Test
	@DisplayName("Test unitario buscar libros titulo like")
	public void testFindLibrosTituloLike() {
		  List<Libro> libros = libroRepository.findByTituloLike("%anillos%");

		  assertEquals(libros.size(),3);

	}

	@Test
	@DisplayName("Test unitario buscar libros cateogorias")
	public void testFindLibrosCategorias() {
		List<String> categorias = Arrays. asList("Terror", "Policiaca");
		List<Libro> libros = libroRepository.findByCategoria_nombreIn(categorias);

		 assertEquals(libros.size(),4);

	}

	@Test
	@DisplayName("Test unitario buscar libros cateogorias not")
	public void testFindLibrosCategoriasNot() {
		List<String> categorias = Arrays. asList("Terror", "Policiaca");
		List<Libro> libros = libroRepository.findByCategoria_nombreNotIn(categorias);

		 assertEquals(libros.size(),20);

	}


	@Test
	@DisplayName("Test unitario buscar libros example titulo")
	public void testFindLibrosExampleTitulo() {

		Libro libro = Libro.builder()
						.titulo("Dracula")
						.favorite(false)
						.build();

		Example<Libro> exLibro = Example.of(libro);

		List<Libro> libros = libroRepository.findAll(exLibro);

		 assertEquals(libros.size(),1);
		 assertEquals(libros.get(0).getAutor().getNombre(),"Bram Stoker");

	}

	@Test
	@DisplayName("Test unitario buscar libros example autor")
	public void testFindLibrosExampleAutor() {

		Autor autor = Autor.builder()
									.id(4)
									.nombre("Bram Stoker")
									.build();
		Libro libro = Libro.builder()
						.autor(autor)
						.build();

		Example<Libro> exLibro = Example.of(libro);

		List<Libro> libros = libroRepository.findAll(exLibro);

		 assertEquals(libros.size(),1);
		 assertEquals(libros.get(0).getTitulo(),"Dracula");

	}

	@Test
	@DisplayName("Test unitario borrar libro")
	public void testDeleteLibro() {
		libroRepository.deleteById(1);
		libroRepository.flush();
	}

}


