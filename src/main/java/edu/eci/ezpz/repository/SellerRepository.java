package edu.eci.ezpz.repository;

import edu.eci.ezpz.repository.document.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SellerRepository extends MongoRepository<Seller, String> {
}
