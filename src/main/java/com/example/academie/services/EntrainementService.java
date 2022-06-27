package com.example.academie.services;


import com.example.academie.dto.EntrainementDto;
import com.example.academie.dto.EquipeDto;

import java.util.List;

public interface EntrainementService {

    List<EntrainementDto> getAllentrainement();
    EntrainementDto getById(String id);
    EntrainementDto addentrainement(EntrainementDto entrainementDto);
    boolean delete(String id);
    EntrainementDto updateentrainement(String id,EntrainementDto entrainementDto) throws Exception;
}
