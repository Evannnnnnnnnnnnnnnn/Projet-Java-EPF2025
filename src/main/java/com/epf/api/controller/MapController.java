package com.epf.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.epf.api.dto.MapDto;
import com.epf.api.mapper.MapDtoMapper;
import com.epf.core.model.Map;
import com.epf.core.service.MapService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/maps")
public class MapController {

    private final MapService mapService;
    private final MapDtoMapper mapDtoMapper;
    
    @Autowired
    public MapController(MapService mapService, MapDtoMapper mapDtoMapper) {
        this.mapService = mapService;
        this.mapDtoMapper = mapDtoMapper;
    }

    @GetMapping
    public List<MapDto> getAllMaps() {
        List<Map> maps = mapService.findAll();
        return mapDtoMapper.mapListModelToListDto(maps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDto> getMapById(@PathVariable Long id) {
        Map map = mapService.findById(id);
        if (map == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(mapDtoMapper.mapModelToDto(map), HttpStatus.OK);
        }
    }
}
