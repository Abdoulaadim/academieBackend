package com.example.academie.services.impl;


import com.example.academie.dto.JoeurDto;
import com.example.academie.dto.services.IMapClassWithDto;
import com.example.academie.entities.JoeurEntity;
import com.example.academie.entities.UserEntity;
import com.example.academie.repositories.JoeurRepository;
import com.example.academie.repositories.UserRepository;
import com.example.academie.services.JoeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JoeurServiceImpl implements JoeurService {




        @Autowired
        JoeurRepository joueurRepository;
        @Autowired
        IMapClassWithDto<JoeurEntity, JoeurDto> Cmapping;

        @Autowired
    UserRepository userRepository;


        @Override
        public List<JoeurDto> getAlljoeur() {
            List<JoeurEntity> house = joueurRepository.findAll();
            return Cmapping.convertListToListDto(house,JoeurDto.class);
        }


        @Override
        public JoeurDto addjoeur(JoeurDto joeurDto) {
            JoeurEntity EEntity = Cmapping.convertToEntity(joeurDto, JoeurEntity.class);
            UserEntity user = userRepository.findById(joeurDto.getUser().getId()).orElse(null);
            if (user != null){
                EEntity.setUser(user);
            }

            EEntity = joueurRepository.save(EEntity);
            return Cmapping.convertToDto(EEntity, JoeurDto.class);
        }

        @Override
        public boolean delete(String id) {

            Optional<JoeurEntity> house = joueurRepository.findById(id);
            if(house == null) return false;
            joueurRepository.deleteById(id);
            return true;
        }

    @Override
    public JoeurEntity getByIdJoeur(String id) {
        Optional<JoeurEntity> joeur = joueurRepository.findById(id);

            return joeur.get();

    }

    @Override
        public JoeurDto updatejoeur(String id, JoeurDto joeurDto) throws Exception {

            JoeurEntity EEntity = joueurRepository.findUserEntitiesById(id);

            if (Objects.isNull(EEntity)) {
                /* handle this exception using {@link RestExceptionHandler} */
                throw new Exception("error to update ");
            }

            joeurDto.setId(id);
            return this.addjoeur(joeurDto);
        }


}
