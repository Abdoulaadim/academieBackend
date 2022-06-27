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
@Document(value = "entrainement")
public class EntrainementEntity {

    @Id
    private String id;
    private String stade;
    private String ville;
    private String description;
    private LocalDateTime date_entrainement;
    private LocalDateTime date_Fin;
    @DBRef
    private EquipeEntity equipe;


}
