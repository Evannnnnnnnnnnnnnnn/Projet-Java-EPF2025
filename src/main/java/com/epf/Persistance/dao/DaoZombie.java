package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.persistance.entities.ZombieEntity;

@Repository
public class DaoZombie {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public DaoZombie(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ZombieEntity> findAll() {
        String sql = "SELECT * FROM pvz.zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }
    
    public ZombieEntity findById(Long id) {
        String sql = "SELECT * FROM zombie WHERE id = ?";
        List<ZombieEntity> zombies = jdbcTemplate.query(sql, new ZombieRowMapper(), id);
        return zombies.isEmpty() ? null : zombies.get(0);
    }
    
    private static class ZombieRowMapper implements RowMapper<ZombieEntity> {
        @Override
        public ZombieEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque | vitesse_de_deplacement | chemin_image 
            ZombieEntity zombie = new ZombieEntity();
            zombie.setId_zombie_entity(rs.getInt("zombie_id")); // Ajustez le nom de la colonne selon votre base de données
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
