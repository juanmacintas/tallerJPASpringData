package es.biblioteca.service;

import java.util.List;

import es.biblioteca.entity.Categoria;



public interface CategoriaService {

    public List<Categoria> findAll();

    public Categoria findById(Integer id);

    public void deleteById(Integer id);

    public Categoria nuevaCategoria(Categoria categoria);
}