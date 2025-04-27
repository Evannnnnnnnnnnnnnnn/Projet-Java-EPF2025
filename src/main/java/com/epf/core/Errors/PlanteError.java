package com.epf.core.Errors;

import com.epf.api.dto.PlanteDto;
import com.epf.core.model.Plante;
import com.epf.persistance.entities.PlanteEntity;

public class PlanteError extends Exception {
    public PlanteError(String message) {
        super(message);
        System.out.println(message);
    }

    public void validatePlante(Plante plante) throws PlanteError {
        if (plante == null) {
            throw new PlanteError("Plante cannot be null");
        }
        if (plante.getNom_plante_model() == null || plante.getNom_plante_model().isEmpty()) {
            throw new PlanteError("Name cannot be empty");
        }
        if (plante.getPoint_de_vie_plante_model() <= 0) {
            throw new PlanteError("Invalid health points: " + plante.getPoint_de_vie_plante_model());
        }
        if (plante.getAttaque_par_seconde_plante_model() <= 0) {
            throw new PlanteError("Invalid attack points: " + plante.getAttaque_par_seconde_plante_model());
        }
        if (plante.getDegat_attaque_plante_model() <= 0) {
            throw new PlanteError("Invalid attack damage: " + plante.getAttaque_par_seconde_plante_model());
        }
        if (plante.getCout_plante_model() <= 0) {
            throw new PlanteError("Invalid cost: " + plante.getCout_plante_model());
        }
        if (plante.getSoleil_par_seconde_plante_model() < 0) {
            throw new PlanteError("Invalid sun points: " + plante.getSoleil_par_seconde_plante_model());
        }

        String effet = plante.getEffet_plante_model();
        if (effet == null || (!effet.equals("normal") && !effet.equals("slow low") &&
                !effet.equals("slow medium") && !effet.equals("slow stop"))) {
            throw new PlanteError(
                    "Invalid effect: " + effet + ". Must be one of: normal, slow low, slow medium, slow stop");
        }
        if (plante.getChemin_image_plante_model() == null || plante.getChemin_image_plante_model().isEmpty()) {
            plante.setChemin_image_plante_model("images\\   plante\\placeholderPlante.png"); // Default image path
        }
    }

    public void validatePlante(PlanteEntity plante) throws PlanteError{
        if (plante == null) {
            throw new PlanteError("Plante cannot be null");
        }
        if (plante.getNom_plante_entity() == null || plante.getNom_plante_entity().isEmpty()) {
            throw new PlanteError("Name cannot be empty");
        }
        if (plante.getPoint_de_vie_plante_entity() <= 0) {
            throw new PlanteError("Invalid health points: " + plante.getPoint_de_vie_plante_entity());
        }
        if (plante.getAttaque_par_seconde_plante_entity() <= 0) {
            throw new PlanteError("Invalid attack points: " + plante.getAttaque_par_seconde_plante_entity());
        }
        if (plante.getDegat_attaque_plante_entity() <= 0) {
            throw new PlanteError("Invalid attack damage: " + plante.getAttaque_par_seconde_plante_entity());
        }
        if (plante.getCout_plante_entity() <= 0) {
            throw new PlanteError("Invalid cost: " + plante.getCout_plante_entity());
        }
        if (plante.getSoleil_par_seconde_plante_entity() < 0) {
            throw new PlanteError("Invalid sun points: " + plante.getSoleil_par_seconde_plante_entity());
        }

        String effet = plante.getEffet_plante_entity();
        if (effet == null || (!effet.equals("normal") && !effet.equals("slow low") &&
                !effet.equals("slow medium") && !effet.equals("slow stop"))) {
            throw new PlanteError(
                    "Invalid effect: " + effet + ". Must be one of: normal, slow low, slow medium, slow stop");
        }
        if (plante.getChemin_image_plante_entity() == null || plante.getChemin_image_plante_entity().isEmpty()) {
            plante.setChemin_image_plante_entity("images\\plante\\placeholderPlante.png"); // Default image path
        }
    }

    public void validatePlante(PlanteDto plante) throws PlanteError{
        if (plante == null) {
            throw new PlanteError("Plante cannot be null");
        }
        if (plante.getNom_plante_dto() == null || plante.getNom_plante_dto().isEmpty()) {
            throw new PlanteError("Name cannot be empty");
        }
        if (plante.getPoint_de_vie_plante_dto() <= 0) {
            throw new PlanteError("Invalid health points: " + plante.getPoint_de_vie_plante_dto());
        }
        if (plante.getAttaque_par_seconde_plante_dto() <= 0) {
            throw new PlanteError("Invalid attack points: " + plante.getAttaque_par_seconde_plante_dto());
        }
        if (plante.getDegat_attaque_plante_dto() <= 0) {
            throw new PlanteError("Invalid attack damage: " + plante.getAttaque_par_seconde_plante_dto());
        }
        if (plante.getCout_plante_dto() <= 0) {
            throw new PlanteError("Invalid cost: " + plante.getCout_plante_dto());
        }
        if (plante.getSoleil_par_seconde_plante_dto() < 0) {
            throw new PlanteError("Invalid sun points: " + plante.getSoleil_par_seconde_plante_dto());
        }

        String effet = plante.getEffet_plante_dto();
        if (effet == null || (!effet.equals("normal") && !effet.equals("slow low") &&
                !effet.equals("slow medium") && !effet.equals("slow stop"))) {
            throw new PlanteError(
                    "Invalid effect: " + effet + ". Must be one of: normal, slow low, slow medium, slow stop");
        }
        if (plante.getChemin_image_plante_dto() == null || plante.getChemin_image_plante_dto().isEmpty()) {
            plante.setChemin_image_plante_dto("images\\plante\\placeholderPlante.png"); // Default image path
        }
    }
}
