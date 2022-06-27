package com.example.academie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntrainementDto {

    private String id;
    private String stade;
    private String description;
    private LocalDateTime date_entrainement;
    private LocalDateTime date_Fin;
    private EquipeDto equipe;
}
