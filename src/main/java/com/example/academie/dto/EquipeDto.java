package com.example.academie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipeDto {

    private String id;
    private String nom;
    private String categorie;
    private String division;



}
