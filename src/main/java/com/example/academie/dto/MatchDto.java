package com.example.academie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDto {

    private String id;
    private String stade;
    private String ville;
    private EquipeDto equipe1;
    private EquipeDto equipe2;
    private LocalDateTime horaire;
}
