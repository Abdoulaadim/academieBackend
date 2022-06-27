package com.example.academie.repositories;

import com.example.academie.entities.JoeurEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoeurRepository extends MongoRepository<JoeurEntity,String> {

        JoeurEntity findUserEntitiesById(String id);

}
