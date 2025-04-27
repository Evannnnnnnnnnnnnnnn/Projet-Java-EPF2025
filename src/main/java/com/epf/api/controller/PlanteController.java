package com.epf.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.api.dto.PlanteDto;
import com.epf.api.mapper.PlanteDtoMapper;
import com.epf.core.model.Plante;
import com.epf.core.service.PlanteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;
    private final PlanteDtoMapper planteDtoMapper;

    @Autowired
    public PlanteController(PlanteService planteService, PlanteDtoMapper planteDtoMapper) {
        this.planteService = planteService;
        this.planteDtoMapper = planteDtoMapper;
    }

    @GetMapping()
    public List<PlanteDto> getAllPlantes() {
        List<Plante> plantes = planteService.findAll();
        return planteDtoMapper.mapListModelToListDto(plantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanteDto> getPlanteById(@PathVariable("id") Long id) {
        Plante plante = planteService.findById(id);
        if (plante == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(planteDtoMapper.mapModelToDto(plante));
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createPlante(@RequestBody PlanteDto planteDto) {
        Plante plante = planteDtoMapper.mapDtoToModel(planteDto);
        planteService.create(plante);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlante(@PathVariable("id") Long id, @RequestBody PlanteDto planteDto) {
        Plante plante = planteDtoMapper.mapDtoToModel(planteDto);
        if (plante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            plante.setId_plante_model(plante.getId_plante_model());
            planteService.update(plante);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlante(@PathVariable("id") Long id) {
        Plante plante = planteService.findById(id);
        if (plante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            planteService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
