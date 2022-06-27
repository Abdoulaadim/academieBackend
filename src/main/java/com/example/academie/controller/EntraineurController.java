package com.example.academie.controller;



import com.example.academie.dto.EntraineurDto;
import com.example.academie.dto.EquipeDto;
import com.example.academie.services.EntraineurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Entraineur")
public class EntraineurController {
    @Autowired
    EntraineurService entraineurService;



    //------- All  : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<EntraineurDto>> getAllentraineur(){
        List<EntraineurDto> joeurDto = entraineurService.getAllentraineur();
        return ResponseEntity.ok(joeurDto);
    }

    //-----------ByID -----------------------------------------------------------------

    @GetMapping("/{id}")
    public ResponseEntity<EntraineurDto> getById(@PathVariable String  id) {
        EntraineurDto sc = entraineurService.getById(id);
        return ResponseEntity.ok().body(sc);
    }

    //------- Add  : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<EntraineurDto> addentraineur(@RequestBody EntraineurDto entraineurDto )  {

        EntraineurDto newentraineur = entraineurService.addentraineur(entraineurDto);
        return new ResponseEntity<EntraineurDto>(newentraineur, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        entraineurService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<EntraineurDto> Updateentraineur(@PathVariable String id, @RequestBody EntraineurDto entraineurDto) throws Exception {

        EntraineurDto uc = entraineurService.updateentraineur(id,entraineurDto);
        return new ResponseEntity<EntraineurDto>(uc, HttpStatus.CREATED);
    }



}
