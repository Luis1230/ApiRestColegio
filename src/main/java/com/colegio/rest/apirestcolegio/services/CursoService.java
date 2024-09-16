package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Curso;
import com.colegio.rest.apirestcolegio.repository.ICursoRepository;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;
import com.colegio.rest.apirestcolegio.services.impl.CRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService extends CRUD<Curso,Integer> implements ICursoService{

    private final ICursoRepository _cursoRepository;

    @Override
    protected IGenericRepository<Curso, Integer> _repository() {
        return _cursoRepository;
    }
}
