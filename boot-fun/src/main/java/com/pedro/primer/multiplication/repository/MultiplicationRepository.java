package com.pedro.primer.multiplication.repository;

import org.springframework.data.repository.CrudRepository;

import com.pedro.primer.multiplication.Multiplication;

/**
* This interface allows us to save and retrieve
Multiplications
*/
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long>{

}
