package com.example.academie.repositories;


import com.example.academie.entities.MatchEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends MongoRepository<MatchEntity,String> {

    MatchEntity findUserEntitiesById(String id);

}
