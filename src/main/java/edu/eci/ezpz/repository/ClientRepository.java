package edu.eci.ezpz.repository;

import edu.eci.ezpz.repository.document.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String > {
    Optional<Client> findByEmail(String id);
}
