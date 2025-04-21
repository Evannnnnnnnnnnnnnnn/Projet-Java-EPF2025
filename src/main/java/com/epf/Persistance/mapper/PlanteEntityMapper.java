package com.epf.persistance.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epf.core.model.Plante;
import com.epf.persistance.entities.PlanteEntity;

@Component
public class PlanteEntityMapper {

    public Plante mapEntityToModel(PlanteEntity entity) {
        if (entity == null) {
            return null;
        } else {
            // id_plante | nom | point_de_vie | attaque_par_seconde | degat_attaque | cout |
            // soleil_par_seconde | effet | chemin_image
            Plante plante = new Plante();
            plante.setId_plante_model(entity.getId_plante_entity());
            plante.setNom_plante_model(entity.getNom_plante_entity());
            plante.setPoint_de_vie_plante_model(entity.getPoint_de_vie_plante_entity());
            plante.setAttaque_par_seconde_plante_model(entity.getAttaque_par_seconde_plante_entity());
            plante.setDegat_attaque_plante_model(entity.getDegat_attaque_plante_entity());
            plante.setCout_plante_model(entity.getCout_plante_entity());
            plante.setSoleil_par_seconde_plante_model(entity.getSoleil_par_seconde_plante_entity());
            plante.setEffet_plante_model(entity.getEffet_plante_entity());
            plante.setChemin_image_plante_model(entity.getChemin_image_plante_entity());

            return plante;
        }
    }
        public List<Plante> mapListEntityToListModel(List<PlanteEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }
}
