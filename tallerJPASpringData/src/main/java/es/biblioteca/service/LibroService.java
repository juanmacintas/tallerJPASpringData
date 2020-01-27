package es.biblioteca.service;

import java.util.List;

import es.biblioteca.entity.Libro;


public interface LibroService {

    public List<Libro> findByFavoriteTrue();

    public List<Libro> findAll();

    public List<Libro> findByExample(Libro libro);

    public Libro findById(Integer id);
}