package com.example.academie.entities;

import com.example.academie.dto.EquipeDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "joeur")
public class JoeurEntity{

    @Id
    private String id;
    private int  age;
    private String poste;
    private int num_short;
    private String nationalite;
    private String taille;
    private String poids;
    @DBRef(lazy = true)
    private UserEntity user;
    @DBRef(lazy = true)
    private EquipeEntity equipe;





}
