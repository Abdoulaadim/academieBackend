package com.example.academie.entities;



import com.example.academie.enums.ERole;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "users")
public class UserEntity {

    @Id
    private String id;
    private String nom;
    private String prenom;
    @Indexed(unique=true)
    private String email;
    private String password;
    private ERole role ;

}
