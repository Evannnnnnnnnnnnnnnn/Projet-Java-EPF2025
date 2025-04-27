package com.epf.core.Errors;

import com.epf.api.dto.MapDto;
import com.epf.core.model.Map;
import com.epf.persistance.entities.MapEntity;

public class MapError extends Exception {
    public MapError(String message) {
        super(message);
        System.out.println(message);
    }

    public void validateMap(Map map) throws MapError {
        if (map == null) {
            throw new MapError("Map cannot be null");
        }
        if (map.getLigne_map_model() < 0 || map.getColonne_map_model() <= 0) {
            throw new MapError("Invalid map dimensions: " + map.getLigne_map_model() + "l x" + map.getColonne_map_model() + "c");
        }
        if (map.getChemin_image_map_model() == null || map.getChemin_image_map_model().isEmpty()) {
            map.setChemin_image_map_model("placeholder.webp"); // Default image path
        }
    }

    public void validateMap(MapEntity map) throws MapError {
        if (map == null) {
            throw new MapError("Map cannot be null");
        }
        if (map.getLigne_map_entity() < 0 || map.getColonne_map_entity() <= 0) {
            throw new MapError("Invalid map dimensions: " + map.getLigne_map_entity() + "l x" + map.getColonne_map_entity() + "c");
        }
        if (map.getChemin_image_map_entity() == null || map.getChemin_image_map_entity().isEmpty()) {
            map.setChemin_image_map_entity("placeholder.webp"); // Default image path
        }
    }

    public void validateMap(MapDto map) throws MapError {
        if (map == null) {
            throw new MapError("Map cannot be null");
        }
        if (map.getLigne_map_dto() < 0 || map.getColonne_map_dto() <= 0) {
            throw new MapError("Invalid map dimensions: " + map.getLigne_map_dto() + "l x" + map.getColonne_map_dto() + "c");
        }
        if (map.getChemin_image_map_dto() == null || map.getChemin_image_map_dto().isEmpty()) {
            map.setChemin_image_map_dto("placeholder.webp"); // Default image path
        }
    }
}
