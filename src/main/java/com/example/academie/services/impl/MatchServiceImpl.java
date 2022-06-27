package com.example.academie.services.impl;

import com.example.academie.dto.MatchDto;
import com.example.academie.dto.ScoreDto;
import com.example.academie.dto.services.IMapClassWithDto;
import com.example.academie.entities.MatchEntity;
import com.example.academie.entities.ScoreEntity;
import com.example.academie.repositories.MatchRepository;
import com.example.academie.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    MatchRepository matchRepository;
    @Autowired
    IMapClassWithDto<MatchEntity, MatchDto> Cmapping;

    @Override
    public List<MatchDto> getAllmatch() {

        List<MatchEntity> match = matchRepository.findAll();
        return Cmapping.convertListToListDto(match,MatchDto.class);
    }

    @Override
    public MatchDto getByIdmatch(String id) {
        MatchEntity current = matchRepository.findUserEntitiesById(id);
        return Cmapping.convertToDto(current, MatchDto.class);
    }

    @Override
    public MatchDto addmatch(MatchDto matchDto) {


        MatchEntity EEntity = Cmapping.convertToEntity(matchDto, MatchEntity.class);
        EEntity = matchRepository.save(EEntity);
        return Cmapping.convertToDto(EEntity, MatchDto.class);
    }

    @Override
    public boolean delete(String id) {
        Optional<MatchEntity> match = matchRepository.findById(id);
        if(match == null) return false;
        matchRepository.deleteById(id);
        return true;
    }

    @Override
    public MatchDto updatematch(String id, MatchDto matchDto) throws Exception {

        MatchEntity EEntity = matchRepository.findUserEntitiesById(id);
        if (Objects.isNull(EEntity)) {
            /* handle this exception using {@link RestExceptionHandler} */
            throw new Exception("error to update ");
        }
        matchDto.setId(id);
        return this.addmatch(matchDto);
    }
}
