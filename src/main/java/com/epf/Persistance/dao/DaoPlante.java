package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.persistance.entities.PlanteEntity;

@Repository
public class DaoPlante {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoPlante(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PlanteEntity> findAll() {
        String sql = "SELECT * FROM pvz.plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    public PlanteEntity findById(Long id) {
        String sql = "SELECT * FROM plante WHERE id = ?";
        List<PlanteEntity> plantes = jdbcTemplate.query(sql, new PlanteRowMapper(), id);
        return plantes.isEmpty() ? null : plantes.get(0);
    }

    private static class PlanteRowMapper implements RowMapper<PlanteEntity> {
        @Override
        public PlanteEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            // id_plante | nom | point_de_vie | attaque_par_seconde | degat_attaque | cout |
            // soleil_par_seconde | effet | chemin_image
            PlanteEntity plante = new PlanteEntity();
            plante.setId_plante_entity(rs.getInt("id_plante"));
            plante.setNom_plante_entity(rs.getString("nom"));
            plante.setPoint_de_vie_plante_entity(rs.getInt("point_de_vie"));
            plante.setAttaque_par_seconde_plante_entity(rs.getDouble("attaque_par_seconde"));
            plante.setDegat_attaque_plante_entity(rs.getInt("degat_attaque"));
            plante.setCout_plante_entity(rs.getInt("cout"));
            plante.setSoleil_par_seconde_plante_entity(rs.getDouble("soleil_par_seconde"));
            plante.setEffet_plante_entity(rs.getString("effet"));
            plante.setChemin_image_plante_entity(rs.getString("chemin_image"));

            return plante;
        }
    }
}
