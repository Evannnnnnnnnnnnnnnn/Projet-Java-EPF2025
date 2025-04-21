package com.epf.persistance.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epf.core.model.Zombie;
import com.epf.persistance.entities.ZombieEntity;

@Component
public class ZombieEntityMapper {
    
    public Zombie mapEntityToModel(ZombieEntity entity) {
        if (entity == null) {
            return null;
        } else {
            // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque |
            // vitesse_de_deplacement | chemin_image
            Zombie zombie = new Zombie();
            zombie.setId_zombie_model(entity.getId_zombie_entity());
            zombie.setNom_zombie_model(entity.getNom_zombie_entity());
            zombie.setPoint_de_vie_zombie_model(entity.getPoint_de_vie_zombie_entity());
            zombie.setAttaque_par_seconde_zombie_model(entity.getAttaque_par_seconde_zombie_entity());
            zombie.setDegat_attaque_zombie_model(entity.getDegat_attaque_zombie_entity());
            zombie.setVitesse_de_deplacement_zombie_model(entity.getVitesse_de_deplacement_zombie_entity());
            zombie.setChemin_image_zombie_model(entity.getChemin_image_zombie_entity());
            return zombie;
        }
    }

    public List<Zombie> mapListEntityToListModel(List<ZombieEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }
}
