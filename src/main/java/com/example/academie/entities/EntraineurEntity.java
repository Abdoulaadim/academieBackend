package com.example.academie.entities;

import com.example.academie.dto.EquipeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "entraineur")
public class EntraineurEntity {

    @Id
    private String id;
    private String nationalite;
    private int age;
    private String anciennete;
    private int nbr_match;
    private String format;
    @DBRef(lazy = true)
    private UserEntity user;
    @DBRef(lazy = true)
    private EquipeEntity equipe;
}
