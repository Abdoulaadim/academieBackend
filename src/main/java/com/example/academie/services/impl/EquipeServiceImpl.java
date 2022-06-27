package com.example.academie.services.impl;


import com.example.academie.dto.EquipeDto;
import com.example.academie.dto.MatchDto;
import com.example.academie.dto.services.IMapClassWithDto;


import com.example.academie.entities.EquipeEntity;
import com.example.academie.entities.JoeurEntity;
import com.example.academie.entities.MatchEntity;
import com.example.academie.entities.UserEntity;
import com.example.academie.repositories.EquipeRepository;
import com.example.academie.repositories.JoeurRepository;
import com.example.academie.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class EquipeServiceImpl implements EquipeService {

    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    JoeurRepository joeurRepository;
    @Autowired
    IMapClassWithDto<EquipeEntity, EquipeDto> Cmapping;

    @Override
    public List<EquipeDto> getAllequipe() {
        List<EquipeEntity> equipe = equipeRepository.findAll();
        return Cmapping.convertListToListDto(equipe,EquipeDto.class);
    }

    @Override
    public EquipeDto addequipe(EquipeDto equipeDto) {


        EquipeEntity EEntity = Cmapping.convertToEntity(equipeDto, EquipeEntity.class);
        EEntity = equipeRepository.save(EEntity);
        return Cmapping.convertToDto(EEntity, EquipeDto.class);
    }

    @Override
    public EquipeDto getById(String id) {
        EquipeEntity current = equipeRepository.findUserEntitiesById(id);
        return Cmapping.convertToDto(current, EquipeDto.class);
    }

    @Override
    public boolean delete(String id) {
        Optional<EquipeEntity> equi = equipeRepository.findById(id);
        if(equi == null) return false;
        equipeRepository.deleteById(id);
        return true;
    }

    @Override
    public EquipeDto updateequipe(String id, EquipeDto equipeDto) throws Exception {

        EquipeEntity EEntity = equipeRepository.findUserEntitiesById(id);
        if (Objects.isNull(EEntity)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new Exception("error to update ");
        }
        equipeDto.setId(id);
        return this.addequipe(equipeDto);
    }
}
