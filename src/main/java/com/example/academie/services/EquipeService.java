package com.example.academie.services;


import com.example.academie.dto.EquipeDto;
import com.example.academie.dto.MatchDto;

import java.util.List;

public interface EquipeService {

    List<EquipeDto> getAllequipe();
    EquipeDto addequipe(EquipeDto equipeDto);
    EquipeDto getById(String id);
    boolean delete(String id);
    EquipeDto updateequipe(String id,EquipeDto equipeDto) throws Exception;
}
