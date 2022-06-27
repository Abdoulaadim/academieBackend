package com.example.academie.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "equipe")
@Builder
public class EquipeEntity {

    @Id
    private String id;
    private String nom;
    private String categorie;
    private String division;



}
