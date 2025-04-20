package com.epf.persistance.entities;

public class ZombieEntity {
    // id_zombie | nom | point_de_vie | attaque_par_seconde | degat_attaque | vitesse_de_deplacement | chemin_image 
    int id_zombie;
    String nom;
    int point_de_vie;
    double attaque_par_seconde;
    int degat_attaque;
    double vitesse_de_deplacement;
    String chemin_image;

    public ZombieEntity() {}

    public ZombieEntity(int id_zombie, String nom, int point_de_vie, double attaque_par_seconde, int degat_attaque, double vitesse_de_deplacement, String chemin_image) {
        this.id_zombie = id_zombie;
        this.nom = nom;
        this.point_de_vie = point_de_vie;
        this.attaque_par_seconde = attaque_par_seconde;
        this.degat_attaque = degat_attaque;
        this.vitesse_de_deplacement = vitesse_de_deplacement;
        this.chemin_image = chemin_image;
    }

    public int getId_zombie_entity() {return id_zombie;}
    public void setId_zombie_entity(int id_zombie) {this.id_zombie = id_zombie;}

    public String getNom_zombie_entity() {return nom;}
    public void setNom_zombie_entity(String nom) {this.nom = nom;}

    public int getPoint_de_vie_zombie_entity() {return point_de_vie;}
    public void setPoint_de_vie_zombie_entity(int point_de_vie) {this.point_de_vie = point_de_vie;}

    public double getAttaque_par_seconde_zombie_entity() {return attaque_par_seconde;}
    public void setAttaque_par_seconde_zombie_entity(double attaque_par_seconde) {this.attaque_par_seconde = attaque_par_seconde;}

    public int getDegat_attaque_zombie_entity() {return degat_attaque;}
    public void setDegat_attaque_zombie_entity(int degat_attaque) {this.degat_attaque = degat_attaque;}

    public double getVitesse_de_deplacement_zombie_entity() {return vitesse_de_deplacement;}
    public void setVitesse_de_deplacement_zombie_entity(double vitesse_de_deplacement) {this.vitesse_de_deplacement = vitesse_de_deplacement;}

    public String getChemin_image_zombie_entity() {return chemin_image;}
    public void setChemin_image_zombie_entity(String chemin_image) {this.chemin_image = chemin_image;}
}
