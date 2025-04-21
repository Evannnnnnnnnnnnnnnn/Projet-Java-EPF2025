package com.epf.persistance.entities;

public class MapEntity {
    //id_map | ligne | colonne | chemin_image  
    int id_map;
    int ligne;
    int colonne;
    String chemin_image;

    public MapEntity() {}

    public MapEntity(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public int getId_map_entity() {return id_map;}
    public void setId_map_entity(int id_map) {this.id_map = id_map;}

    public int getLigne_map_entity() {return ligne;}
    public void setLigne_map_entity(int ligne) {this.ligne = ligne;}

    public int getColonne_map_entity() {return colonne;}
    public void setColonne_map_entity(int colonne) {this.colonne = colonne;}

    public String getChemin_image_map_entity() {return chemin_image;}
    public void setChemin_image_map_entity(String chemin_image) {this.chemin_image = chemin_image;}
}
