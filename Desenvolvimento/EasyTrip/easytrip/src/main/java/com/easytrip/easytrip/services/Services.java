package com.easytrip.easytrip.services;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface Services<T> {


    Page<T> findAll(Pageable pageable);

    T findById(Long id);

    T saveOrUpdate(T t);

    String deleteById(Long id);
}
