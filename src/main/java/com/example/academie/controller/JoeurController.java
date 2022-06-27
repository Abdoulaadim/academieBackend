package com.example.academie.controller;

import com.example.academie.dto.JoeurDto;
import com.example.academie.entities.JoeurEntity;
import com.example.academie.services.JoeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joeur")
public class JoeurController {
    @Autowired
    JoeurService joeurService;



    //------- All users : -------------------------------------------------------------------

    @GetMapping
    public ResponseEntity<List<JoeurDto>> getAlljoeur(){
        List<JoeurDto> joeurDto = joeurService.getAlljoeur();
        return ResponseEntity.ok(joeurDto);
    }


    @GetMapping("/{id}")
    public ResponseEntity<JoeurEntity> getByIdJoeur(@PathVariable String  id) {
        JoeurEntity joeur = joeurService.getByIdJoeur(id);
        return ResponseEntity.ok().body(joeur);
    }


    //------- Add user : ------------------------------------------------------------------
    @PostMapping()
    public ResponseEntity<JoeurDto> addjoeur(@RequestBody JoeurDto joeurDto )  {

        JoeurDto newjoeur = joeurService.addjoeur(joeurDto);
        return new ResponseEntity<JoeurDto>(newjoeur, HttpStatus.CREATED);
    }

    //------- Delete  : --------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){

        joeurService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<JoeurDto> Updatejoeur(@PathVariable String id, @RequestBody JoeurDto joeurDto) throws Exception {

        JoeurDto uc = joeurService.updatejoeur(id,joeurDto);
        return new ResponseEntity<JoeurDto>(uc, HttpStatus.CREATED);
    }



}
