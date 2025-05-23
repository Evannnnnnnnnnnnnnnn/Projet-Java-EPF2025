package com.epf.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epf.api.dto.MapDto;
import com.epf.core.model.Map;

@Component
public class MapDtoMapper {

    public MapDto mapModelToDto(Map map) {
        if (map == null) {
            return null; //TODO faire une erreur
        }

        MapDto dto = new MapDto();
        // id_map | ligne | colonne | chemin_image
        dto.setId_map_dto(map.getId_map_model());
        dto.setLigne_map_dto(map.getLigne_map_model());
        dto.setColonne_map_dto(map.getColonne_map_model());
        dto.setChemin_image_map_dto(map.getChemin_image_map_model());

        return dto;
    }

    public Map mapDtoToModel(MapDto dto) {
        if (dto == null) {
            return null; //TODO faire une erreur
        }

        Map map = new Map();
        // id_map | ligne | colonne | chemin_image
        map.setId_map_model(dto.getId_map_dto());
        map.setLigne_map_model(dto.getLigne_map_dto());
        map.setColonne_map_model(dto.getColonne_map_dto());
        map.setChemin_image_map_model(dto.getChemin_image_map_dto());

        return map;
    }

    public List<MapDto> mapListModelToListDto(List<Map> maps) {
        return maps.stream()
                .map(this::mapModelToDto)
                .toList();
    }
}
