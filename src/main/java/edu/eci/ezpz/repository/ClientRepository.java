package edu.eci.ezpz.repository;

import edu.eci.ezpz.repository.document.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String > {




}
