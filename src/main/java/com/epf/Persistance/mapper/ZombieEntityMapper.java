package com.epf.persistance.mapper;

import java.util.List;

import com.epf.persistance.entities.ZombieEntity;

public class ZombieEntityMapper {
    public Zombie mapEntityToModel(ZombieEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Zombie zombie = new Zombie();
        zombie.setId(entity.getId());
        zombie.setFirstName(entity.getFirstName());
        zombie.setLastName(entity.getLastName());
        zombie.setSubmissionDate(entity.getSubmissionDate());
        zombie.setScore(entity.getScore());
        return zombie;
    }
    
    public List<Zombie> mapListEntityToListModel(List<ZombieEntity> entities) {
        return entities.stream()
                .map(this::mapEntityToModel)
                .toList();
    }
}
