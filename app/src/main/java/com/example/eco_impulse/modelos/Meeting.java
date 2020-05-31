package com.example.eco_impulse.modelos;

public class Meeting {

    private String tittle, description, imageUrl, hostId, date,  location, materials;
    //Para pruebas offline
    public int imageId=0;

    public Meeting(String tittle, String description, String imageUrl, String hostId, String date, String location, String materials) {
        this.tittle = tittle;
        this.description = description;
        this.imageUrl = imageUrl;
        this.hostId = hostId;
        this.date = date;
        this.location = location;
        this.materials = materials;
    }
    //Para pruebas offline
    public Meeting(String tittle, int imageId, String date, String location){
        this.tittle = tittle;
        this.imageId = imageId;
        this.date = date;
        this.location = location;
    }



    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }
}
