package com.epf.persistance.entities;

public class Zombies {
    // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque | vitesse_de_deplacement | chemin_image 
    int id_zombie;
    String nom;
    int point_de_vie;
    double attaque_par_seconde;
    int degat_attaque;
    double vitesse_de_deplacement;
    String chemin_image;

    public Zombies(int id_zombie, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, double vitesse_de_deplacement, String chemin_image) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
    }
}
