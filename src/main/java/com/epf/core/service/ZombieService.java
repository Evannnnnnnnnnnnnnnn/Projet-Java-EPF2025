package com.epf.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.core.model.Zombie;
import com.epf.persistance.repository.ZombieRepository;

@Service
public class ZombieService {

    private final ZombieRepository zombieRepository;

    @Autowired
    public ZombieService(ZombieRepository zombieRepository) {
        this.zombieRepository = zombieRepository;
    }

    public List<Zombie> findAll() {
        return zombieRepository.findAll();
    }

    public Zombie findById(Long id) {
        return zombieRepository.findById(id);
    }
}
