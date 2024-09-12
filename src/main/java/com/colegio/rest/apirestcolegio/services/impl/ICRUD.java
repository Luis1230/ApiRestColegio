package com.colegio.rest.apirestcolegio.services.impl;

import java.util.List;

public interface ICRUD <T,ID>{

    T save(T t) throws Exception;
    T update(ID id,T t) throws Exception;
    List<T> findAll() throws Exception;
    T findById(ID id) throws Exception;
    boolean delete(ID id) throws Exception;

}
