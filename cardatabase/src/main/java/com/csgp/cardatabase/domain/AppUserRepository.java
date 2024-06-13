package com.csgp.cardatabase.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface AppUserRepository extends CrudRepository <AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}