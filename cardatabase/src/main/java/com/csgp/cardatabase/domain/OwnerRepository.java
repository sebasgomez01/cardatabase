package com.csgp.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OwnerRepository extends CrudRepository <Owner, Long> {

}
