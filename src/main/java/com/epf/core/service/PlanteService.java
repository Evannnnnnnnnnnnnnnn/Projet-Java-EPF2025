package com.epf.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.core.model.Plante;
import com.epf.persistance.repository.PlanteRepository;

@Service
public class PlanteService {

    private final PlanteRepository planteRepository;

    @Autowired
    public PlanteService(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    public List<Plante> findAll() {
        return planteRepository.findAll();
    }

    public Plante findById(Long id) {
        return planteRepository.findById(id);
    }

    public void create(Plante plante) {
        planteRepository.create(plante);
    }

    public void update(Plante plante) {
        planteRepository.update(plante);
    }

    public void delete(Long id) {
        planteRepository.delete(id);
    }
}
