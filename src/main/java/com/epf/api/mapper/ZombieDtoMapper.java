package com.epf.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epf.api.dto.ZombieDto;
import com.epf.core.model.Zombie;

@Component
public class ZombieDtoMapper {

    public ZombieDto mapModelToDto(Zombie zombie) {
        if (zombie == null) {
            return null;
        }
        
        ZombieDto dto = new ZombieDto();
        // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque | vitesse_de_deplacement | chemin_image 
        dto.setId_zombie_dto(zombie.getId_zombie_model());
        dto.setNom_zombie_dto(zombie.getNom_zombie_model());
        dto.setPoint_de_vie_zombie_dto(zombie.getPoint_de_vie_zombie_model());
        dto.setAttaque_par_seconde_zombie_dto(zombie.getAttaque_par_seconde_zombie_model());
        dto.setDegat_attaque_zombie_dto(zombie.getDegat_attaque_zombie_model());
        dto.setVitesse_de_deplacement_zombie_dto(zombie.getVitesse_de_deplacement_zombie_model());
        dto.setChemin_image_zombie_dto(zombie.getChemin_image_zombie_model());

        return dto;
    }
    
    public List<ZombieDto> mapListModelToListDto(List<Zombie> zombie) {
        return zombie.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }
}
