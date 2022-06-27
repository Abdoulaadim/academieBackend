package com.example.academie.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "score")
public class ScoreEntity {

    @Id
    private String id;
    private int score;
    @DBRef
    private EquipeEntity equipe;
}
