package es.biblioteca.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import es.biblioteca.entity.InfoAdicional;


@DataJpaTest
@DisplayName("JUnit Test unitario repositorio InfoAdicional")
public class InfoAdicionalRepositoryTest {

	@Autowired
	InfoAdicionalRepository infoAdicionalRepository;


	@Test
	@Sql("classpath:/datasets/biblioteca.sql")
	@DisplayName("Test unitario buscar todos")
	public void testFindAll() {

		  List<InfoAdicional> infoAdicional = infoAdicionalRepository.findAll();

		  assertEquals(infoAdicional.size(), 26);
	}


	@Test
	@Sql("classpath:/datasets/biblioteca.sql")
	@DisplayName("Test unitario buscar por id")
	public void testFindById() {

		  Optional<InfoAdicional> infoAdicional = infoAdicionalRepository.findById(1);

		  assertEquals(infoAdicional.isPresent(), true);
		  assertEquals(infoAdicional.get().getLibro().getTitulo(),"Los Pilares de la Tierra");

		  Optional<InfoAdicional> infoAdicionalFail = infoAdicionalRepository.findById(50);

		  assertEquals(infoAdicionalFail.isPresent(), false);

	}


}
