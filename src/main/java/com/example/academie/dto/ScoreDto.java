package com.example.academie.dto;

import com.example.academie.entities.EquipeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDto {

    private String id;
    private int score;
    private EquipeEntity equipe;
}
