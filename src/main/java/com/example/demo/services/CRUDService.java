package com.example.demo.services;

import java.util.List;

/**
 * @author OKala III
 * */

public interface CRUDService<E, Dto> {


    E create(Dto e);

    List<E> create(List<Dto> d);

    E update(Dto d);

    List<E> update(List<Dto> d);

    Boolean delete(Long id);


    List<E> findAll();

    E findById(long id);



}
