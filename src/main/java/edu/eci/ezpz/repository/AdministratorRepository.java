package edu.eci.ezpz.repository;
import edu.eci.ezpz.repository.document.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AdministratorRepository extends MongoRepository<Administrator, String > {
    Optional<Administrator> findByEmail(String email );
}