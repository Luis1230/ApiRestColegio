package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.repository.IEstudianteRepository;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;
import com.colegio.rest.apirestcolegio.services.impl.CRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteService extends CRUD<Estudiante,Integer> implements IEstudianteService {

    private final IEstudianteRepository _estudianteRepository;

    @Override
    protected IGenericRepository<Estudiante, Integer> _repository() {
        return _estudianteRepository;
    }

    @Override
    public List<Estudiante> findByOrderByEdadDesc() {
        return _estudianteRepository.findByOrderByEdadDesc();
    }

    @Override
    public List<Estudiante> estudiantesPorEdad() {
        List<Estudiante> objEstudiantes =_estudianteRepository.findAll().stream()
                .sorted(Comparator.comparingInt(Estudiante::getEdad).reversed())
                .collect(Collectors.toList());
        return objEstudiantes;
    }
}
