package com.example.academie.services;



import com.example.academie.dto.EntraineurDto;
import com.example.academie.dto.EquipeDto;

import java.util.List;

public interface EntraineurService {

    List<EntraineurDto> getAllentraineur();
    EntraineurDto getById(String id);
    EntraineurDto addentraineur(EntraineurDto entraineurDto);
    boolean delete(String id);
    EntraineurDto updateentraineur(String id,EntraineurDto entraineurDto) throws Exception;
}
