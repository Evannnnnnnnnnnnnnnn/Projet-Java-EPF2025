package com.epf.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.epf.api.dto.MapDto;
import com.epf.api.mapper.MapDtoMapper;
import com.epf.core.model.Map;
import com.epf.core.service.MapService;
import com.epf.core.service.ZombieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/maps", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:5173")
public class MapController {

    private final ZombieService zombieService;

    private final MapService mapService;
    private final MapDtoMapper mapDtoMapper;

    @Autowired
    public MapController(MapService mapService, MapDtoMapper mapDtoMapper, ZombieService zombieService) {
        this.mapService = mapService;
        this.mapDtoMapper = mapDtoMapper;
        this.zombieService = zombieService;
    }

    @GetMapping // pour les get (infos)
    public List<MapDto> getAllMaps() {
        List<Map> maps = mapService.findAll();
        return mapDtoMapper.mapListModelToListDto(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDto> getMapById(@PathVariable("id") Long id) {
        Map map = mapService.findById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(mapDtoMapper.mapModelToDto(map), HttpStatus.OK);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) // pour les post (ajouter) // (consumes = MediaType.APPLICATION_JSON_VALUE) pour pouvoir utiliser postman et les json
    public ResponseEntity<Void> createMap(@RequestBody MapDto mapDto) {
        Map map = mapDtoMapper.mapDtoToModel(mapDto);
        mapService.create(map);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // pour les put (modifier)
    public ResponseEntity<Void> updateMap(@PathVariable("id") Long id, @RequestBody MapDto mapDto) {
        Map existingMap = mapService.findById(id);
        if (existingMap == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Map map = mapDtoMapper.mapDtoToModel(mapDto);
            map.setId_map_model(existingMap.getId_map_model()); // Conserver l'ID existant
            mapService.update(map);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}") // pour les delete (supprimer)
    public ResponseEntity<Void> deleteMap(@PathVariable("id") Long id) {
        Map map = mapService.findById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // supprimer les zombies de la map avant de supprimer la map
            zombieService.deleteZombieFromMap(map);
            // supprimer la map
            mapService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
