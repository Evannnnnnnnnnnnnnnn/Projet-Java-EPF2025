package com.epf.persistance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.persistance.entities.MapEntity;

@Repository
public class DaoMap {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DaoMap(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<MapEntity> findAll() {
        String sql = "SELECT * FROM pvz.map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    public MapEntity findById(Long id) {
        String sql = "Select * FROM pvz.map WHERE id_map = ?";
        List<MapEntity> maps = jdbcTemplate.query(sql, new MapRowMapper(), id);
        return maps.isEmpty() ? null : maps.get(0);
    }

    public void create(MapEntity map) {
        String sql = "INSERT INTO pvz.map (ligne, colonne, chemin_image) VALUES (?, ?, ?)"; // On ne met pas id_map car c'est auto-incrémenté
        jdbcTemplate.update(
                sql,
                map.getLigne_map_entity(),
                map.getColonne_map_entity(),
                map.getChemin_image_map_entity());
    }

    public void update(MapEntity map) {
        String sql = "UPDATE pvz.map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(
                sql,
                map.getLigne_map_entity(),
                map.getColonne_map_entity(),
                map.getChemin_image_map_entity(),
                map.getId_map_entity());
    }

    public void delete(Long id) {
        String sql = "DELETE FROM pvz.map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class MapRowMapper implements RowMapper<MapEntity> {
        @Override
        public MapEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            // id_map | ligne | colonne | chemin_image
            MapEntity map = new MapEntity();
            map.setId_map_entity(rs.getInt("id_map"));
            map.setLigne_map_entity(rs.getInt("ligne"));
            map.setColonne_map_entity(rs.getInt("colonne"));
            map.setChemin_image_map_entity(rs.getString("chemin_image"));

            return map;
        }
    }
}
