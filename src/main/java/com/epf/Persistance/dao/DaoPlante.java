package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.core.Errors.PlanteError;
import com.epf.persistance.entities.PlanteEntity;

@Repository
public class DaoPlante {
    private final JdbcTemplate jdbcTemplate;
    private final PlanteError planteError;

    @Autowired
    public DaoPlante(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.planteError = new PlanteError("DAO Plante Error");
    }

    public List<PlanteEntity> findAll() {
        String sql = "SELECT * FROM pvz.plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    public PlanteEntity findById(Long id) {
        String sql = "SELECT * FROM pvz.plante WHERE id_plante = ?";
        List<PlanteEntity> plantes = jdbcTemplate.query(sql, new PlanteRowMapper(), id);
        return plantes.isEmpty() ? null : plantes.get(0);
    }

    public void create(PlanteEntity plante) {
        try {
            planteError.validatePlante(plante); // Validation de l'entité avant l'insertion
        } catch (Error e) {
            System.out.println("Erreur de validation : " + e.getMessage());
            return; // Sortir de la méthode si la validation échoue
        } catch (Exception e) {
            System.out.println("Les problèmes :(\n" + e.getMessage());
            return; // Sortir de la méthode s'il y a une autre exception
        }
        String sql = "INSERT INTO pvz.plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // On ne met pas id_plante car c'est auto-incrémenté
        jdbcTemplate.update(
                sql,
                plante.getNom_plante_entity(),
                plante.getPoint_de_vie_plante_entity(),
                plante.getAttaque_par_seconde_plante_entity(),
                plante.getDegat_attaque_plante_entity(),
                plante.getCout_plante_entity(),
                plante.getSoleil_par_seconde_plante_entity(),
                plante.getEffet_plante_entity(),
                plante.getChemin_image_plante_entity());
    }

    public void update(PlanteEntity plante) {
        try {
            planteError.validatePlante(plante); // Validation de l'entité avant l'insertion
        } catch (Error e) {
            System.out.println("Erreur de validation : " + e.getMessage());
            return; // Sortir de la méthode si la validation échoue
        } catch (Exception e) {
            System.out.println("Les problèmes :(\n" + e.getMessage());
            return; // Sortir de la méthode s'il y a une autre exception
        }
        String sql = "UPDATE pvz.plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(
                sql,
                plante.getNom_plante_entity(),
                plante.getPoint_de_vie_plante_entity(),
                plante.getAttaque_par_seconde_plante_entity(),
                plante.getDegat_attaque_plante_entity(),
                plante.getCout_plante_entity(),
                plante.getSoleil_par_seconde_plante_entity(),
                plante.getEffet_plante_entity(),
                plante.getChemin_image_plante_entity(),
                plante.getId_plante_entity());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM pvz.plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
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
