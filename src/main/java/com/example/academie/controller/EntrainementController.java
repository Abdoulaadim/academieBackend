package com.example.academie.controller;


import com.example.academie.dto.EntrainementDto;
import com.example.academie.dto.EntraineurDto;
import com.example.academie.services.EntrainementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrainement")
public class EntrainementController {
    @Autowired
    EntrainementService entrainementService;



    //------- All  : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<EntrainementDto>> getAllentraineur(){
        List<EntrainementDto> entrainementDto = entrainementService.getAllentrainement();
        return ResponseEntity.ok(entrainementDto);
    }

    //-----------ByID -----------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<EntrainementDto> getById(@PathVariable String  id) {
        EntrainementDto sc = entrainementService.getById(id);
        return ResponseEntity.ok().body(sc);
    }



    //------- Add  : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<EntrainementDto> addentraineur(@RequestBody EntrainementDto entrainementDto )  {

        EntrainementDto newentrainement = entrainementService.addentrainement(entrainementDto);
        return new ResponseEntity<EntrainementDto>(newentrainement, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        entrainementService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<EntrainementDto> Updateentraineur(@PathVariable String id, @RequestBody EntrainementDto entrainementDto) throws Exception {

        EntrainementDto uc = entrainementService.updateentrainement(id,entrainementDto);
        return new ResponseEntity<EntrainementDto>(uc, HttpStatus.CREATED);
    }



}
