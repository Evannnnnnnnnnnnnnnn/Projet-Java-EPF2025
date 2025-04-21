package com.epf.api.dto;

public class PlanteDto {

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

    public PlanteDto() {}

    public PlanteDto(int id_plante, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, int cout, double soleil_par_seconde, String effet, String chemin_image) {
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

    public int getId_plante_dto() {return id_plante;}
    public void setId_plante_dto(int id_plante) {this.id_plante = id_plante;}

    public String getNom_plante_dto() {return nom;}
    public void setNom_plante_dto(String nom) {this.nom = nom;}

    public int getPoint_de_vie_plante_dto() {return point_de_vie;}
    public void setPoint_de_vie_plante_dto(int point_de_vie) {this.point_de_vie = point_de_vie;}

    public double getAttaque_par_seconde_plante_dto() {return attaque_par_seconde;}
    public void setAttaque_par_seconde_plante_dto(double attaque_par_seconde) {this.attaque_par_seconde = attaque_par_seconde;}

    public int getDegat_attaque_plante_dto() {return degat_attaque;}
    public void setDegat_attaque_plante_dto(int degat_attaque) {this.degat_attaque = degat_attaque;}

    public int getCout_plante_dto() {return cout;}
    public void setCout_plante_dto(int cout) {this.cout = cout;}

    public double getSoleil_par_seconde_plante_dto() {return soleil_par_seconde;}
    public void setSoleil_par_seconde_plante_dto(double soleil_par_seconde) {this.soleil_par_seconde = soleil_par_seconde;}

    public String getEffet_plante_dto() {return effet;}
    public void setEffet_plante_dto(String effet) {this.effet = effet;}

    public String getChemin_image_plante_dto() {return chemin_image;}
    public void setChemin_image_plante_dto(String chemin_image) {this.chemin_image = chemin_image;}
}
