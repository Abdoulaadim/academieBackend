package com.example.academie.controller;



import com.example.academie.dto.MatchDto;
import com.example.academie.dto.ScoreDto;
import com.example.academie.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    MatchService matchService;



    //------- All  : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<MatchDto>> getAllmatch(){
        List<MatchDto> match = matchService.getAllmatch();
        return ResponseEntity.ok(match);
    }


    //-----------ByID -----------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<MatchDto> getById(@PathVariable String  id) {
        MatchDto sc = matchService.getByIdmatch(id);
        return ResponseEntity.ok().body(sc);
    }

    //------- Add  : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<MatchDto> addmatch(@RequestBody MatchDto matchDto )  {

        MatchDto newmatch = matchService.addmatch(matchDto);
        return new ResponseEntity<MatchDto>(newmatch, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        matchService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<MatchDto> Updatematch(@PathVariable String id, @RequestBody MatchDto matchDto) throws Exception {

        MatchDto uc = matchService.updatematch(id,matchDto);
        return new ResponseEntity<MatchDto>(uc, HttpStatus.CREATED);
    }



}
