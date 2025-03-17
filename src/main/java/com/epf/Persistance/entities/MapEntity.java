package com.epf.persistance.entities;

public class MapEntity {
    //id_map | ligne | colonne | chemin_image  
    int id_map;
    int ligne;
    int colonne;
    String chemin_image;

    public MapEntity(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public int getId_map() {return id_map;}

    public int getLigne() {return ligne;}
    public void setLigne(int ligne) {this.ligne = ligne;}

    public int getColonne() {return colonne;}
    public void setColonne(int colonne) {this.colonne = colonne;}

    public String getChemin_image() {return chemin_image;}
    public void setChemin_image(String chemin_image) {this.chemin_image = chemin_image;}
}
