package com.colegio.rest.apirestcolegio.services.impl;

import com.colegio.rest.apirestcolegio.exception.ModelNotFoundException;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;

import java.util.List;

public abstract class CRUD <T,ID> implements ICRUD<T,ID>{

    protected abstract IGenericRepository<T,ID> _repository();

    @Override
    public T save(T t) throws Exception {
        return _repository().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        T x = _repository().findById(id).orElse(null);
        if (x != null)
            return _repository().save(t);
        return null;
    }

    @Override
    public List<T> findAll() throws Exception {
        return _repository().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return _repository().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        _repository().findById(id).orElseThrow(() -> new ModelNotFoundException("No se encontró el id: " + id));
        _repository().deleteById(id);
    }
}
