package com.example.academie.services;


import com.example.academie.dto.MatchDto;
import com.example.academie.dto.ScoreDto;

import java.util.List;

public interface MatchService {

    List<MatchDto> getAllmatch();
    MatchDto getByIdmatch(String id);
    MatchDto addmatch(MatchDto matchDto);
    boolean delete(String id);
    MatchDto updatematch(String id,MatchDto matchDto) throws Exception;
}
