package com.epf.api.controller;

import com.epf.api.dto.ZombieDto;
import com.epf.api.mapper.ZombieDtoMapper;
import com.epf.core.model.Zombie;
import com.epf.core.service.ZombieService;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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
    public ResponseEntity<ZombieDto> getZombieById(@PathVariable("id") Long id) {
        Zombie zombie = zombieService.findById(id);
        if (zombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(zombieDtoMapper.mapModelToDto(zombie), HttpStatus.OK);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) // pour les post (ajouter) // (consumes =
                                                              // MediaType.APPLICATION_JSON_VALUE) pour pouvoir utiliser
                                                              // postman et les json
    public ResponseEntity<Void> createZombie(@RequestBody ZombieDto zombieDto) {
        Zombie zombie = zombieDtoMapper.mapDtoToModel(zombieDto);
        zombieService.create(zombie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateZombie(@PathVariable("id") Long id, @RequestBody ZombieDto zombieDto) {
        Zombie zombie = zombieDtoMapper.mapDtoToModel(zombieDto);
        if (zombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            zombie.setId_zombie_model(zombie.getId_zombie_model());
            zombieService.update(zombie);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZombie(@PathVariable("id") Long id) {
        Zombie zombie = zombieService.findById(id);
        if (zombie == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            zombieService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
