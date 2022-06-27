package com.example.academie.services.impl;


import com.example.academie.dto.EntraineurDto;
import com.example.academie.dto.JoeurDto;
import com.example.academie.dto.MatchDto;
import com.example.academie.dto.services.IMapClassWithDto;
import com.example.academie.entities.EntraineurEntity;
import com.example.academie.entities.JoeurEntity;
import com.example.academie.entities.MatchEntity;
import com.example.academie.repositories.EntraineurRepository;
import com.example.academie.services.EntraineurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntraineurServiceImpl implements EntraineurService {

    @Autowired
    EntraineurRepository entraineurRepository;
    @Autowired
    IMapClassWithDto<EntraineurEntity, EntraineurDto> Cmapping;

    @Override
    public List<EntraineurDto> getAllentraineur() {

        List<EntraineurEntity> entraineur = entraineurRepository.findAll();
        return Cmapping.convertListToListDto(entraineur,EntraineurDto.class);
    }

    @Override
    public EntraineurDto getById(String id) {
        EntraineurEntity current = entraineurRepository.findUserEntitiesById(id);
        return Cmapping.convertToDto(current, EntraineurDto.class);
    }

    @Override
    public EntraineurDto addentraineur(EntraineurDto entraineurDto) {


        EntraineurEntity EEntity = Cmapping.convertToEntity(entraineurDto, EntraineurEntity.class);
        EEntity = entraineurRepository.save(EEntity);
        return Cmapping.convertToDto(EEntity, EntraineurDto.class);
    }

    @Override
    public boolean delete(String id) {
        Optional<EntraineurEntity> house = entraineurRepository.findById(id);
        if(house == null) return false;
        entraineurRepository.deleteById(id);
        return true;
    }

    @Override
    public EntraineurDto updateentraineur(String id, EntraineurDto entraineurDto) throws Exception {

        EntraineurEntity EEntity = entraineurRepository.findUserEntitiesById(id);
        if (Objects.isNull(EEntity)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new Exception("error to update ");
        }
        entraineurDto.setId(id);
        return this.addentraineur(entraineurDto);
    }
}
