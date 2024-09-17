package com.colegio.rest.apirestcolegio.repository;

import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;

import java.util.List;

public interface IEstudianteRepository extends IGenericRepository<Estudiante,Integer> {

    List<Estudiante> findByOrderByEdadDesc();

}
