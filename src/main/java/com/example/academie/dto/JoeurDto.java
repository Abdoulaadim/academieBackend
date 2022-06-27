package com.example.academie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoeurDto  {

    private String id;
    private int  age;
    private String poste;
    private int num_short;
    private String nationalite;
    private String taille;
    private String poids;
    private EquipeDto equipe;
    private UserDto user;

}
