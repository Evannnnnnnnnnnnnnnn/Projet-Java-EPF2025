package com.epf.persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epf.core.model.Zombie;
import com.epf.persistance.dao.DaoZombie;
import com.epf.persistance.mapper.ZombieEntityMapper;

@Repository
public class ZombieRepository {
    
    private final DaoZombie zombieDAO;
    private final ZombieEntityMapper mapper;
    
    @Autowired
    public ZombieRepository(DaoZombie zombieDAO, ZombieEntityMapper mapper) {
        this.zombieDAO = zombieDAO;
        this.mapper = mapper;
    }
    
    public List<Zombie> findAll() {
        return mapper.mapListEntityToListModel(zombieDAO.findAll());
    }
    
    public Zombie findById(Long id) {
        return mapper.mapEntityToModel(zombieDAO.findById(id));
    }
}

