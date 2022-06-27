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
public class EntraineurDto  {

    private String id;
    private String nationalite;
    private int age;
    private String anciennete;
    private int nbr_match;
    private String format;
    private EquipeDto equipe;
    private UserDto user;
}
