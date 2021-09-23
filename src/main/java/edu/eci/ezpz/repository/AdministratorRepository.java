package edu.eci.ezpz.repository;
import edu.eci.ezpz.repository.document.Administrator;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface AdministratorRepository extends MongoRepository<Administrator, String > {}