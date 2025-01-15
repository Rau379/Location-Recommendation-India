package com.tvsmotor.Authservice.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tvsmotor.Authservice.Model.Dealer;

import java.util.Optional;

@Repository
public interface DealerRepository extends MongoRepository<Dealer, String> {
    Optional<Dealer> findByUsername(String username);
}