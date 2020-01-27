package es.biblioteca.service;

import java.util.List;

import es.biblioteca.entity.Editorial;


public interface EditorialService {

    public List<Editorial> findAll();

    public Editorial findById(Integer id);

    public void deleteById(Integer id);

    public Editorial nuevaEditorial(Editorial editorial);
}