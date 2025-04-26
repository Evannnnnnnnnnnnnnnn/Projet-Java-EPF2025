package com.epf.persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epf.core.model.Map;
import com.epf.persistance.dao.DaoMap;
import com.epf.persistance.mapper.MapEntityMapper;

@Repository
public class MapRepository {

    private final DaoMap mapDAO;
    private final MapEntityMapper mapper;

    @Autowired
    public MapRepository(DaoMap mapDAO, MapEntityMapper mapper) {
        this.mapDAO = mapDAO;
        this.mapper = mapper;
    }

    public List<Map> findAll() {
        return mapper.mapListEntityToListModel(mapDAO.findAll());
    }

    public Map findById(Long id) {
        return mapper.mapEntityToModel(mapDAO.findById(id));
    }

    public void create(Map map) {
        mapDAO.create(mapper.mapModelToEntity(map));
    }

    public void update(Map map) {
        mapDAO.update(mapper.mapModelToEntity(map));
    }

    public void delete(Long id) {
        mapDAO.delete(id);
    }
}
