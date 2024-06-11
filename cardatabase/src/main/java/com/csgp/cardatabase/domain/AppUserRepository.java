package com.csgp.cardatabase.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository <AppUser, Long> {
    Optional<AppUSer> findByUsername(String username);
}