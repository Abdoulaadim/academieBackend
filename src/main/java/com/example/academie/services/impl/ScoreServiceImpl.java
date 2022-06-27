package com.example.academie.services.impl;


import com.example.academie.dto.ScoreDto;
import com.example.academie.dto.UserDto;
import com.example.academie.dto.services.IMapClassWithDto;


import com.example.academie.entities.ScoreEntity;
import com.example.academie.entities.UserEntity;
import com.example.academie.repositories.ScoreRepository;
import com.example.academie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    IMapClassWithDto<ScoreEntity, ScoreDto> Cmapping;

    @Override
    public List<ScoreDto> getAllScore() {

        List<ScoreEntity> score = scoreRepository.findAll();
        return Cmapping.convertListToListDto(score,ScoreDto.class);
    }

    @Override
    public ScoreDto addScore(ScoreDto scoreDto) {


        ScoreEntity EEntity = Cmapping.convertToEntity(scoreDto, ScoreEntity.class);
        EEntity = scoreRepository.save(EEntity);
        return Cmapping.convertToDto(EEntity, ScoreDto.class);
    }

    @Override
    public boolean delete(String id) {
        Optional<ScoreEntity> match = scoreRepository.findById(id);
        if(match == null) return false;
        scoreRepository.deleteById(id);
        return true;
    }

    @Override
    public ScoreDto getByIdScore(String id) {

        ScoreEntity current = scoreRepository.findUserEntitiesById(id);
        return Cmapping.convertToDto(current, ScoreDto.class);
    }

    @Override
    public ScoreDto updateScore(String id, ScoreDto scoreDto) throws Exception {

        ScoreEntity EEntity = scoreRepository.findUserEntitiesById(id);
        if (Objects.isNull(EEntity)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new Exception("error to update ");
        }
        scoreDto.setId(id);
        return this.addScore(scoreDto);
    }
}
