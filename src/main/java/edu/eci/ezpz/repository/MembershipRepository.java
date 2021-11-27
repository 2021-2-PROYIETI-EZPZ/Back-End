package edu.eci.ezpz.repository;

import edu.eci.ezpz.repository.document.MemberShip;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface MembershipRepository extends MongoRepository<MemberShip, String > {

}
