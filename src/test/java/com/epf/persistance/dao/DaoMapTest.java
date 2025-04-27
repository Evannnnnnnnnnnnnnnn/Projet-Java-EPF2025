package com.epf.persistance.dao;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.epf.persistance.entities.MapEntity;
import static org.junit.Assert.*;

public class DaoMapTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    private DaoMap daoMap;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        daoMap = new DaoMap(jdbcTemplate);
    }

    @Test
    public void testFindAll() {
        // Création des données de test
        MapEntity map1 = new MapEntity(1, 5, 9, "images/map/map1.png");
        MapEntity map2 = new MapEntity(2, 6, 9, "images/map/map2.png");
        List<MapEntity> expectedMaps = Arrays.asList(map1, map2);

        // Configuration du comportement simulé
        when(jdbcTemplate.query(
            eq("SELECT * FROM pvz.map"), 
            any(DaoMap.MapRowMapper.class)))
            .thenReturn(expectedMaps);

        // Exécution du test
        List<MapEntity> actualMaps = daoMap.findAll();

        // Vérifications
        assertNotNull(actualMaps);
        assertEquals(2, actualMaps.size());
        assertEquals(expectedMaps, actualMaps);

        // Vérification que la méthode query a été appelée exactement une fois
        verify(jdbcTemplate, times(1)).query(
            eq("SELECT * FROM pvz.map"), 
            any(DaoMap.MapRowMapper.class));
    }
}