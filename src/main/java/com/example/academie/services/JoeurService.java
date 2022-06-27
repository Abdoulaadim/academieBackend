package com.example.academie.services;



import com.example.academie.dto.JoeurDto;
import com.example.academie.entities.JoeurEntity;

import java.util.List;

public interface JoeurService {
    List<JoeurDto> getAlljoeur();
    JoeurDto addjoeur(JoeurDto joeurDto);
    boolean delete(String id);
    JoeurEntity getByIdJoeur(String id);
    JoeurDto updatejoeur(String id,JoeurDto joeurDto) throws Exception;
}
