package com.epf.persistance.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epf.core.model.Map;
import com.epf.persistance.entities.MapEntity;

@Component
public class MapEntityMapper {

    public Map mapEntityToModel(MapEntity entity) {
        if (entity == null) {
            return null; //TODO Raise Error
        } else {
            // id_map | ligne | colonne | chemin_image
            Map map = new Map();
            map.setId_map_model(entity.getId_map_entity());
            map.setLigne_map_model(entity.getLigne_map_entity());
            map.setColonne_map_model(entity.getColonne_map_entity());
            map.setChemin_image_map_model(entity.getChemin_image_map_entity());

            return map;
        }
    }

    public MapEntity mapModelToEntity(Map model) {
        if (model == null) {
            return null; //TODO Raise Error
        } else {
            // id_map | ligne | colonne | chemin_image
            MapEntity map = new MapEntity();
            map.setId_map_entity(model.getId_map_model());
            map.setLigne_map_entity(model.getLigne_map_model());
            map.setColonne_map_entity(model.getColonne_map_model());
            map.setChemin_image_map_entity(model.getChemin_image_map_model());

            return map;
        }
    }

    public List<Map> mapListEntityToListModel(List<MapEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }

}
