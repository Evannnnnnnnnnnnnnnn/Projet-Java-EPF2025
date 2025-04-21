package com.epf.core.model;

public class Map {
    //id_map | ligne | colonne | chemin_image  
    int id_map;
    int ligne;
    int colonne;
    String chemin_image;

    public Map() {}

    public Map(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public int getId_map_model() {return id_map;}
    public void setId_map_model(int id_map) {this.id_map = id_map;}

    public int getLigne_map_model() {return ligne;}
    public void setLigne_map_model(int ligne) {this.ligne = ligne;}

    public int getColonne_map_model() {return colonne;}
    public void setColonne_map_model(int colonne) {this.colonne = colonne;}

    public String getChemin_image_map_model() {return chemin_image;}
    public void setChemin_image_map_model(String chemin_image) {this.chemin_image = chemin_image;}
}
