package com.example.academie.services;



import com.example.academie.dto.ScoreDto;

import java.util.List;

public interface ScoreService {

    List<ScoreDto> getAllScore();
    ScoreDto addScore(ScoreDto scoreDto);
    boolean delete(String id);
    ScoreDto getByIdScore(String id);
    ScoreDto updateScore(String id,ScoreDto scoreDto) throws Exception;
}
