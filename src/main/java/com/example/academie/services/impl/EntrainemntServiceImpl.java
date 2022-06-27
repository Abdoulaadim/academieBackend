package com.example.academie.services.impl;

import com.example.academie.dto.EntrainementDto;
import com.example.academie.dto.EntraineurDto;
import com.example.academie.dto.EquipeDto;
import com.example.academie.dto.services.IMapClassWithDto;
import com.example.academie.entities.EntrainementEntity;
import com.example.academie.entities.EntraineurEntity;
import com.example.academie.repositories.EntrainementRepository;
import com.example.academie.services.EntrainementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntrainemntServiceImpl implements EntrainementService {

    @Autowired
    EntrainementRepository entrainementRepository;
    @Autowired
    IMapClassWithDto<EntrainementEntity, EntrainementDto> Cmapping;

    @Override
    public List<EntrainementDto> getAllentrainement() {

        List<EntrainementEntity> entrainement = entrainementRepository.findAll();
        return Cmapping.convertListToListDto(entrainement,EntrainementDto.class);
    }

    @Override
    public EntrainementDto getById(String id) {
        EntrainementEntity current = entrainementRepository.findUserEntitiesById(id);
        return Cmapping.convertToDto(current, EntrainementDto.class);
    }


    @Override
    public EntrainementDto addentrainement(EntrainementDto entrainementDto) {


        EntrainementEntity EEntity = Cmapping.convertToEntity(entrainementDto, EntrainementEntity.class);
        EEntity = entrainementRepository.save(EEntity);
        return Cmapping.convertToDto(EEntity, EntrainementDto.class);
    }

    @Override
    public boolean delete(String id) {
        Optional<EntrainementEntity> entrainement = entrainementRepository.findById(id);
        if(entrainement == null) return false;
        entrainementRepository.deleteById(id);
        return true;
    }

    @Override
    public EntrainementDto updateentrainement(String id, EntrainementDto entrainementDto) throws Exception {

        EntrainementEntity EEntity = entrainementRepository.findUserEntitiesById(id);
        if (Objects.isNull(EEntity)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new Exception("error to update ");
        }
        entrainementDto.setId(id);
        return this.addentrainement(entrainementDto);
    }
}
