package com.epf.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.epf.api.dto.ZombieDto;
import com.epf.api.mapper.ZombieDtoMapper;
import com.epf.core.model.Zombie;
import com.epf.core.service.ZombieService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;
    private final ZombieDtoMapper zombieDtoMapper;
    
    @Autowired
    public ZombieController(ZombieService zombieService, ZombieDtoMapper zombieDtoMapper) {
        this.zombieService = zombieService;
        this.zombieDtoMapper = zombieDtoMapper;
    }

    @GetMapping
    public List<ZombieDto> getAllZombies() {
        List<Zombie> zombies = zombieService.findAll();
        return zombieDtoMapper.mapListModelToListDto(zombies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZombieDto> getZombieById(@PathVariable Long id) {
        Zombie zombie = zombieService.findById(id);
        if (zombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(zombieDtoMapper.mapModelToDto(zombie), HttpStatus.OK);
        }
    }
}
