package com.example.boostan.Model;

import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("toxic")
    private String toxic;

    @SerializedName("pests")
    private String pests;

    @SerializedName("light")
    private String light;

    @SerializedName("title")
    private String name;

    @SerializedName("cat_id")
    private String catId;

    @SerializedName("soil")
    private String soil;

    @SerializedName("id")
    private String id;

    @SerializedName("image")
    private String image;

    @SerializedName("water")
    private String water;

    @SerializedName("introduction")
    private String introduction;

    @SerializedName("fertilizer")
    private String fertilizer;

    @SerializedName("reproduction")
    private String reproduction;

    @SerializedName("temperate")
    private String temperate;

    @SerializedName("prune")
    private String prune;

    @SerializedName("humidity")
    private String humidity;

    @SerializedName("further_information")
    private String further_information;

    public void setToxic(String toxic){
        this.toxic = toxic;
    }

    public String getToxic(){
        return toxic;
    }

    public void setPests(String pests){
        this.pests = pests;
    }

    public String getPests(){
        return pests;
    }

    public void setLight(String light){
        this.light = light;
    }

    public String getLight(){
        return light;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCatId(String catId){
        this.catId = catId;
    }

    public String getCatId(){
        return catId;
    }

    public void setSoil(String soil){
        this.soil = soil;
    }

    public String getSoil(){
        return soil;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setImage(String imageId){
        this.image = imageId;
    }

    public String getImage(){
        return image;
    }

    public void setWater(String water){
        this.water = water;
    }

    public String getWater(){
        return water;
    }

    public void setIntroduction(String introduction){
        this.introduction = introduction;
    }

    public String getIntroduction(){
        return introduction;
    }

    public void setFertilizer(String fertilizer){
        this.fertilizer = fertilizer;
    }

    public String getFertilizer(){
        return fertilizer;
    }

    public String getReproduction() {
        return reproduction;
    }

    public void setReproduction(String reproduction) {
        this.reproduction = reproduction;
    }

    public String getTemperate() {
        return temperate;
    }

    public void setTemperate(String temperate) {
        this.temperate = temperate;
    }

    public String getPrune() {
        return prune;
    }

    public void setPrune(String prune) {
        this.prune = prune;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFurther_information() {
        return further_information;
    }

    public void setFurther_information(String further_information) {
        this.further_information = further_information;
    }
}
