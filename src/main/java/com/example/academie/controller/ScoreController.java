package com.example.academie.controller;

import com.example.academie.dto.MatchDto;
import com.example.academie.dto.ScoreDto;
import com.example.academie.dto.UserDto;
import com.example.academie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;



    //------- All  : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<ScoreDto>> getAllScore(){
        List<ScoreDto> score = scoreService.getAllScore();
        return ResponseEntity.ok(score);
    }


    //-----------ByID -----------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<ScoreDto> getById(@PathVariable String  id) {
        ScoreDto sc = scoreService.getByIdScore(id);
        return ResponseEntity.ok().body(sc);
    }
    //------- Add  : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<ScoreDto> addUser(@RequestBody ScoreDto scoreDto )  {

        ScoreDto newscore = scoreService.addScore(scoreDto);
        return new ResponseEntity<ScoreDto>(newscore, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        scoreService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<ScoreDto> UpdateScore(@PathVariable String id, @RequestBody ScoreDto scoreDto) throws Exception {

        ScoreDto uc = scoreService.updateScore(id,scoreDto);
        return new ResponseEntity<ScoreDto>(uc, HttpStatus.CREATED);
    }

}
