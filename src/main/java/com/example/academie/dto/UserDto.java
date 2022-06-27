package com.example.academie.dto;

import com.example.academie.enums.ERole;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private ERole role;

}
