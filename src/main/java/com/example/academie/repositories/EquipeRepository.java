package com.example.academie.repositories;


import com.example.academie.entities.EquipeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipeRepository extends MongoRepository<EquipeEntity,String> {

    EquipeEntity findUserEntitiesById(String id);
}
