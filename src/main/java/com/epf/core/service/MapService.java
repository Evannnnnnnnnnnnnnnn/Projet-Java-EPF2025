package com.epf.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.core.model.Map;
import com.epf.persistance.repository.MapRepository;

@Service
public class MapService {

    private final MapRepository MapRepository;

    @Autowired
    public MapService(MapRepository MapRepository) {
        this.MapRepository = MapRepository;
    }

    public List<Map> findAll() {
        return MapRepository.findAll();
    }

    public Map findById(Long id) {
        return MapRepository.findById(id);
    }

}
