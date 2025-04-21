package com.epf.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.api.dto.PlanteDto;
import com.epf.api.mapper.PlanteDtoMapper;
import com.epf.core.model.Plante;
import com.epf.core.service.PlanteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
    public ResponseEntity<PlanteDto> getPlanteById(@PathVariable Long id) {
        Plante plante = planteService.findById(id);
        if (plante == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(planteDtoMapper.mapModelToDto(plante));
        }
    }

}
