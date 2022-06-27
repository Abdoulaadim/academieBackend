package com.example.academie.repositories;



import com.example.academie.entities.EntrainementEntity;
import com.example.academie.entities.EntraineurEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrainementRepository  extends MongoRepository<EntrainementEntity,String> {

    EntrainementEntity findUserEntitiesById(String id);

}