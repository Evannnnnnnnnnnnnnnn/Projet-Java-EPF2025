package com.epf.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.epf.api.dto.PlanteDto;
import com.epf.core.model.Plante;

@Component
public class PlanteDtoMapper {
    public PlanteDto mapModelToDto(Plante plante) {
        if (plante == null) {
            return null;//TODO faire une erreur
        }

        PlanteDto dto = new PlanteDto();
        // id_plante | nom | point_de_vie | attaque_par_seconde | degat_attaque | cout |
        // soleil_par_seconde | effet | chemin_image
        dto.setId_plante_dto(plante.getId_plante_model());
        dto.setNom_plante_dto(plante.getNom_plante_model());
        dto.setPoint_de_vie_plante_dto(plante.getPoint_de_vie_plante_model());
        dto.setAttaque_par_seconde_plante_dto(plante.getAttaque_par_seconde_plante_model());
        dto.setDegat_attaque_plante_dto(plante.getDegat_attaque_plante_model());
        dto.setCout_plante_dto(plante.getCout_plante_model());
        dto.setSoleil_par_seconde_plante_dto(plante.getSoleil_par_seconde_plante_model());
        dto.setEffet_plante_dto(plante.getEffet_plante_model());
        dto.setChemin_image_plante_dto(plante.getChemin_image_plante_model());

        return dto;
    }

    public Plante mapDtoToModel(PlanteDto dto) {
        if (dto == null) {
            return null;//TODO faire une erreur
        }

        Plante plante = new Plante();
        // id_plante | nom | point_de_vie | attaque_par_seconde | degat_attaque | cout |
        // soleil_par_seconde | effet | chemin_image
        plante.setId_plante_model(dto.getId_plante_dto());
        plante.setNom_plante_model(dto.getNom_plante_dto());
        plante.setPoint_de_vie_plante_model(dto.getPoint_de_vie_plante_dto());
        plante.setAttaque_par_seconde_plante_model(dto.getAttaque_par_seconde_plante_dto());
        plante.setDegat_attaque_plante_model(dto.getDegat_attaque_plante_dto());
        plante.setCout_plante_model(dto.getCout_plante_dto());
        plante.setSoleil_par_seconde_plante_model(dto.getSoleil_par_seconde_plante_dto());
        plante.setEffet_plante_model(dto.getEffet_plante_dto());
        plante.setChemin_image_plante_model(dto.getChemin_image_plante_dto());

        return plante;
    }

    public List<PlanteDto> mapListModelToListDto(List<Plante> plantes) {
        return plantes.stream()
                .map(this::mapModelToDto)
                .collect(Collectors.toList());
    }
}
