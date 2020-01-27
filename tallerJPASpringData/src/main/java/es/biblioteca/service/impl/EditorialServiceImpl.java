package es.biblioteca.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.biblioteca.entity.Editorial;
import es.biblioteca.repository.EditorialRepository;
import es.biblioteca.service.EditorialService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepository editorialRepository;


	@Override
	public List<Editorial> findAll() {
		log.debug("Se obtienen todas las editoriales");
		return editorialRepository.findAll();
	}


	@Override
	public Editorial findById(Integer id) {
		log.debug("Se obtiene la editorial con id:" + id);
		return editorialRepository.getOne(id);
	}


	@Override
	public void deleteById(Integer id) {
		log.debug("Se elimina la editorial con id:" + id);
		editorialRepository.deleteById(id);

	}


	@Override
	public Editorial nuevaEditorial(Editorial editorial) {
		log.debug("Se añade la editorial:" + editorial);
		return editorialRepository.save(editorial);
	}

}
