package com.epf.api.dto;

public class MapDto {
    //id_map | ligne | colonne | chemin_image  
    int id_map;
    int ligne;
    int colonne;
    String chemin_image;

    public MapDto() {}

    public MapDto(int id_map, int ligne, int colonne, String chemin_image) {
        this.id_map = id_map;
        this.ligne = ligne;
        this.colonne = colonne;
        this.chemin_image = chemin_image;
    }

    public int getId_map_dto() {return id_map;}
    public void setId_map_dto(int id_map) {this.id_map = id_map;}

    public int getLigne_map_dto() {return ligne;}
    public void setLigne_map_dto(int ligne) {this.ligne = ligne;}

    public int getColonne_map_dto() {return colonne;}
    public void setColonne_map_dto(int colonne) {this.colonne = colonne;}

    public String getChemin_image_map_dto() {return chemin_image;}
    public void setChemin_image_map_dto(String chemin_image) {this.chemin_image = chemin_image;}
}
