package com.example.academie.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(value = "match")
public class MatchEntity {
    @Id
    private String id;
    private String stade;
    private String ville;
    @DBRef
    private EquipeEntity equipe1;
    @DBRef
    private EquipeEntity equipe2;
    private LocalDateTime horaire;
}
