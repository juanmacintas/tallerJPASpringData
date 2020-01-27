package es.biblioteca.service;

import java.util.List;

import es.biblioteca.entity.Autor;

public interface AutorService {

    public List<Autor> findAll();

    public Autor findById(Integer id);

    public void deleteById(Integer id);

    public Autor nuevoAutor(Autor autor);
}