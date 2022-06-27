package com.example.academie.repositories;

import com.example.academie.entities.EntraineurEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EntraineurRepository  extends MongoRepository<EntraineurEntity,String>{

        EntraineurEntity findUserEntitiesById(String id);

}
