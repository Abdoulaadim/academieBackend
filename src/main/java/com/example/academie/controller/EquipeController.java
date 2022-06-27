package com.example.academie.controller;



import com.example.academie.dto.EquipeDto;
import com.example.academie.dto.MatchDto;
import com.example.academie.services.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {

    @Autowired
    EquipeService equipeService;



    //------- All  : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<EquipeDto>> getAllequipe(){

        List<EquipeDto> equipeDto = equipeService.getAllequipe();
        return ResponseEntity.ok(equipeDto);
    }

    //-----------ByID -----------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<EquipeDto> getById(@PathVariable String  id) {
        EquipeDto sc = equipeService.getById(id);
        return ResponseEntity.ok().body(sc);
    }


    //------- Add  : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<EquipeDto> addequipe(@RequestBody EquipeDto equipeDto )  {

        EquipeDto newequipe = equipeService.addequipe(equipeDto);
        return new ResponseEntity<EquipeDto>(newequipe, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        equipeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<EquipeDto> Updateequipe(@PathVariable String id, @RequestBody EquipeDto equipeDto) throws Exception {

        EquipeDto uc = equipeService.updateequipe(id,equipeDto);
        return new ResponseEntity<EquipeDto>(uc, HttpStatus.CREATED);
    }



}