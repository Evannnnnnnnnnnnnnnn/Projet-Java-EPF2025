package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.core.Errors.ZombieError;
import com.epf.core.model.Map;
import com.epf.persistance.entities.ZombieEntity;

@Repository
public class DaoZombie {
    private final JdbcTemplate jdbcTemplate;
    private final ZombieError zombieError;
    
    @Autowired
    public DaoZombie(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.zombieError = new ZombieError("DAO Zombie Error");
    }

    public List<ZombieEntity> findAll() {
        String sql = "SELECT * FROM pvz.zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }
    
    public ZombieEntity findById(Long id) {
        String sql = "SELECT * FROM pvz.zombie WHERE id_zombie = ?";
        List<ZombieEntity> zombies = jdbcTemplate.query(sql, new ZombieRowMapper(), id);
        return zombies.isEmpty() ? null : zombies.get(0);
    }

    public void create(ZombieEntity zombie) {
        try {
            zombieError.validateZombie(zombie); // Validation de l'entité avant l'insertion
        } catch (Error e) {
            System.out.println("Erreur de validation : " + e.getMessage());
            return; // Sortir de la méthode si la validation échoue
        } catch (Exception e) {
            System.out.println("Les problèmes :(\n" + e.getMessage());
            return; // Sortir de la méthode s'il y a une autre exception
        }
        String sql = "INSERT INTO pvz.zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image) VALUES (?, ?, ?, ?, ?, ?)"; // On ne met pas id_zombie car c'est auto-incrémenté
        jdbcTemplate.update(
                sql,
                zombie.getNom_zombie_entity(),
                zombie.getPoint_de_vie_zombie_entity(),
                zombie.getAttaque_par_seconde_zombie_entity(),
                zombie.getDegat_attaque_zombie_entity(),
                zombie.getVitesse_de_deplacement_zombie_entity(),
                zombie.getChemin_image_zombie_entity());
    }

    public void update(ZombieEntity zombie) {
        try {
            zombieError.validateZombie(zombie); // Validation de l'entité avant l'insertion
        } catch (Error e) {
            System.out.println("Erreur de validation : " + e.getMessage());
            return; // Sortir de la méthode si la validation échoue
        } catch (Exception e) {
            System.out.println("Les problèmes :(\n" + e.getMessage());
            return; // Sortir de la méthode s'il y a une autre exception
        }
        String sql = "UPDATE pvz.zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ? WHERE id_zombie = ?";
        jdbcTemplate.update(
                sql,
                zombie.getNom_zombie_entity(),
                zombie.getPoint_de_vie_zombie_entity(),
                zombie.getAttaque_par_seconde_zombie_entity(),
                zombie.getDegat_attaque_zombie_entity(),
                zombie.getVitesse_de_deplacement_zombie_entity(),
                zombie.getChemin_image_zombie_entity(),
                zombie.getId_zombie_entity());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM pvz.zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    public void deleteFromMap(Map mapToDel) {
        String sql = "DELETE FROM pvz.zombie WHERE id_map = ?";
        jdbcTemplate.update(sql, mapToDel.getId_map_model());
    }
    
    private static class ZombieRowMapper implements RowMapper<ZombieEntity> {
        @Override
        public ZombieEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque | vitesse_de_deplacement | chemin_image 
            ZombieEntity zombie = new ZombieEntity();
            zombie.setId_zombie_entity(rs.getInt("id_zombie"));
            zombie.setNom_zombie_entity(rs.getString("nom"));
            zombie.setPoint_de_vie_zombie_entity(rs.getInt("point_de_vie"));
            zombie.setAttaque_par_seconde_zombie_entity(rs.getDouble("attaque_par_seconde"));
            zombie.setDegat_attaque_zombie_entity(rs.getInt("degat_attaque"));
            zombie.setVitesse_de_deplacement_zombie_entity(rs.getDouble("vitesse_de_deplacement"));
            zombie.setChemin_image_zombie_entity(rs.getString("chemin_image"));

            return zombie;
        }
    }
}
