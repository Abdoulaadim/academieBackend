package com.example.academie.repositories;


import com.example.academie.entities.ScoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends MongoRepository<ScoreEntity,String> {
    ScoreEntity findUserEntitiesById(String id);
}
