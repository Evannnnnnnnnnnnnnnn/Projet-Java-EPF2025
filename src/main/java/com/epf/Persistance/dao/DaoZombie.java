package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.persistance.entities.ZombieEntity;

public class DaoZombie {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public DaoZombie(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ZombieEntity> findAll() {
        String sql = "SELECT * FROM pvz.zombie";
        return jdbcTemplate.query(sql, new ReportRowMapper());
    }
    
    public ZombieEntity findById(Long id) {
        String sql = "SELECT nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image FROM zombie WHERE id = ?";
        List<ZombieEntity> zombies = jdbcTemplate.query(sql, new ReportRowMapper(), id);
        return zombies.isEmpty() ? null : zombies.get(0);
    }
    
    private static class ReportRowMapper implements RowMapper<ReportEntity> {
        @Override
        public ReportEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ReportEntity report = new ReportEntity();
            report.setId(rs.getLong("id"));
            report.setFirstName(rs.getString("first_name"));
            report.setLastName(rs.getString("last_name"));
            report.setSubmissionDate(rs.getDate("submission_date"));
            report.setScore(rs.getInt("score"));
            return report;
        }
    }
}
