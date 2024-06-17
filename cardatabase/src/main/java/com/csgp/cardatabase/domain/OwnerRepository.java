package com.csgp.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.Optional;

public interface OwnerRepository extends CrudRepository <Owner, Long> {
    // query para el test que chequea la adición de usuarios a la base de datos
    Optional<Owner> findByFirstname(String firstName);
}
