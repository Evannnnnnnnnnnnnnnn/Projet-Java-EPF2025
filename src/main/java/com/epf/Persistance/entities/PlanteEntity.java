package com.epf.persistance.entities;

public class PlanteEntity {
    // id_plante | nom | point_de_vie | attaque_par_seconde | degat_attaque | cout | soleil_par_seconde | effet | chemin_image
    int id_plante;
    String nom;
    int point_de_vie;
    double attaque_par_seconde;
    int degat_attaque;
    int cout;
    double soleil_par_seconde;
    String effet;
    String chemin_image;

    public PlanteEntity() {}

    public PlanteEntity(int id_plante, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, int cout, double soleil_par_seconde, String effet, String chemin_image) {
        this.id_plante = id_plante;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.cout = cout;
        this.soleil_par_seconde = soleil_par_seconde;
        this.effet = effet;
        this.chemin_image = chemin_image;
    }

    public int getId_plante_entity() {return id_plante;}
    public void setId_plante_entity(int id_plante) {this.id_plante = id_plante;}

    public String getNom_plante_entity() {return nom;}
    public void setNom_plante_entity(String nom) {this.nom = nom;}

    public int getPoint_de_vie_plante_entity() {return point_de_vie;}
    public void setPoint_de_vie_plante_entity(int point_de_vie) {this.point_de_vie = point_de_vie;}

    public double getAttaque_par_seconde_plante_entity() {return attaque_par_seconde;}
    public void setAttaque_par_seconde_plante_entity(double attaque_par_seconde) {this.attaque_par_seconde = attaque_par_seconde;}

    public int getDegat_attaque_plante_entity() {return degat_attaque;}
    public void setDegat_attaque_plante_entity(int degat_attaque) {this.degat_attaque = degat_attaque;}

    public int getCout_plante_entity() {return cout;}
    public void setCout_plante_entity(int cout) {this.cout = cout;}

    public double getSoleil_par_seconde_plante_entity() {return soleil_par_seconde;}
    public void setSoleil_par_seconde_plante_entity(double soleil_par_seconde) {this.soleil_par_seconde = soleil_par_seconde;}

    public String getEffet_plante_entity() {return effet;}
    public void setEffet_plante_entity(String effet) {this.effet = effet;}

    public String getChemin_image_plante_entity() {return chemin_image;}
    public void setChemin_image_plante_entity(String chemin_image) {this.chemin_image = chemin_image;}
}
