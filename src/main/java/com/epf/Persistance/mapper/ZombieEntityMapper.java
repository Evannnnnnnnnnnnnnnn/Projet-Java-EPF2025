package com.epf.persistance.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epf.core.model.Zombie;
import com.epf.persistance.entities.ZombieEntity;

@Component
public class ZombieEntityMapper {
    
    public Zombie mapEntityToModel(ZombieEntity entity) {
        if (entity == null) {
            return null;//TODO Raise Error
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

    public ZombieEntity mapModelToEntity(Zombie model) {
        if (model == null) {
            return null;//TODO Raise Error
        } else {
            // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque |
            // vitesse_de_deplacement | chemin_image
            ZombieEntity zombie = new ZombieEntity();
            zombie.setId_zombie_entity(model.getId_zombie_model());
            zombie.setNom_zombie_entity(model.getNom_zombie_model());
            zombie.setPoint_de_vie_zombie_entity(model.getPoint_de_vie_zombie_model());
            zombie.setAttaque_par_seconde_zombie_entity(model.getAttaque_par_seconde_zombie_model());
            zombie.setDegat_attaque_zombie_entity(model.getDegat_attaque_zombie_model());
            zombie.setVitesse_de_deplacement_zombie_entity(model.getVitesse_de_deplacement_zombie_model());
            zombie.setChemin_image_zombie_entity(model.getChemin_image_zombie_model());
            return zombie;
        }
    }

    public List<Zombie> mapListEntityToListModel(List<ZombieEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }
}
