package com.epf.core.Errors;

import com.epf.api.dto.ZombieDto;
import com.epf.core.model.Zombie;
import com.epf.persistance.entities.ZombieEntity;

public class ZombieError extends Exception {
    public ZombieError(String message) {
        super(message);
        System.out.println(message);
    }

    public void validateZombie(ZombieEntity zombie) throws ZombieError {
        if (zombie == null) {
            throw new ZombieError("Zombie cannot be null");
        }
        if (zombie.getNom_zombie_entity() == null || zombie.getNom_zombie_entity().isEmpty()) {
            throw new ZombieError("Name cannot be empty");
        }
        if (zombie.getPoint_de_vie_zombie_entity() <= 0) {
            throw new ZombieError("Invalid health points: " + zombie.getPoint_de_vie_zombie_entity());
        }
        if (zombie.getAttaque_par_seconde_zombie_entity() <= 0) {
            throw new ZombieError("Invalid attack points: " + zombie.getAttaque_par_seconde_zombie_entity());
        }
        if (zombie.getDegat_attaque_zombie_entity() <= 0) {
            throw new ZombieError("Invalid attack damage: " + zombie.getDegat_attaque_zombie_entity());
        }
        if (zombie.getVitesse_de_deplacement_zombie_entity() <= 0) {
            throw new ZombieError("Invalid speed: " + zombie.getVitesse_de_deplacement_zombie_entity());
        }
        if (zombie.getChemin_image_zombie_entity() == null || zombie.getChemin_image_zombie_entity().isEmpty()) {
            zombie.setChemin_image_zombie_entity("placeholder.webp"); // Default image path
        }
    }

    public void validateZombie(Zombie zombie) throws ZombieError {
        if (zombie == null) {
            throw new ZombieError("Zombie cannot be null");
        }
        if (zombie.getNom_zombie_model() == null || zombie.getNom_zombie_model().isEmpty()) {
            throw new ZombieError("Name cannot be empty");
        }
        if (zombie.getPoint_de_vie_zombie_model() <= 0) {
            throw new ZombieError("Invalid health points: " + zombie.getPoint_de_vie_zombie_model());
        }
        if (zombie.getAttaque_par_seconde_zombie_model() <= 0) {
            throw new ZombieError("Invalid attack points: " + zombie.getAttaque_par_seconde_zombie_model());
        }
        if (zombie.getDegat_attaque_zombie_model() <= 0) {
            throw new ZombieError("Invalid attack damage: " + zombie.getDegat_attaque_zombie_model());
        }
        if (zombie.getVitesse_de_deplacement_zombie_model() <= 0) {
            throw new ZombieError("Invalid speed: " + zombie.getVitesse_de_deplacement_zombie_model());
        }
        if (zombie.getChemin_image_zombie_model() == null || zombie.getChemin_image_zombie_model().isEmpty()) {
            zombie.setChemin_image_zombie_model("placeholder.webp"); // Default image path
        }
    }

    public void validateZombie(ZombieDto zombie) throws ZombieError {
        if (zombie == null) {
            throw new ZombieError("Zombie cannot be null");
        }
        if (zombie.getNom_zombie_dto() == null || zombie.getNom_zombie_dto().isEmpty()) {
            throw new ZombieError("Name cannot be empty");
        }
        if (zombie.getPoint_de_vie_zombie_dto() <= 0) {
            throw new ZombieError("Invalid health points: " + zombie.getPoint_de_vie_zombie_dto());
        }
        if (zombie.getAttaque_par_seconde_zombie_dto() <= 0) {
            throw new ZombieError("Invalid attack points: " + zombie.getAttaque_par_seconde_zombie_dto());
        }
        if (zombie.getDegat_attaque_zombie_dto() <= 0) {
            throw new ZombieError("Invalid attack damage: " + zombie.getDegat_attaque_zombie_dto());
        }
        if (zombie.getVitesse_de_deplacement_zombie_dto() <= 0) {
            throw new ZombieError("Invalid speed: " + zombie.getVitesse_de_deplacement_zombie_dto());
        }
        if (zombie.getChemin_image_zombie_dto() == null || zombie.getChemin_image_zombie_dto().isEmpty()) {
            zombie.setChemin_image_zombie_dto("placeholder.webp"); // Default image path
        }
    }
}
