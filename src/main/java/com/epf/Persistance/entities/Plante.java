package com.epf.persistance.entities;

public class Plante {
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

    public Plante(int id_plante, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, int cout, double soleil_par_seconde, String effet, String chemin_image) {
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

}
