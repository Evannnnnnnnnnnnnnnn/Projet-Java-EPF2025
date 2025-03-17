package com.epf.persistance.entities;

public class Map {
    //id_map | ligne | colonne | chemin_image  
    int id_map;
    int ligne;
    int colonne;
    String chemin_image;

    public Map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

}
