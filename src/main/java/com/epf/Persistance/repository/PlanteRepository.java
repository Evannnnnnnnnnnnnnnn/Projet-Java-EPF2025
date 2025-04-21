package com.epf.persistance.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epf.core.model.Plante;
import com.epf.persistance.dao.DaoPlante;
import com.epf.persistance.mapper.PlanteEntityMapper;

@Repository
public class PlanteRepository {

    private final DaoPlante planteDAO;
    private final PlanteEntityMapper mapper;

    @Autowired
    public PlanteRepository(DaoPlante planteDAO, PlanteEntityMapper mapper) {
        this.planteDAO = planteDAO;
        this.mapper = mapper;
    }

    public List<Plante> findAll() {
        return mapper.mapListEntityToListModel(planteDAO.findAll());
    }

    public Plante findById(Long id) {
        return mapper.mapEntityToModel(planteDAO.findById(id));
    }
}
