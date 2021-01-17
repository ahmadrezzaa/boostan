package com.example.boostan.Model;

import com.google.gson.annotations.SerializedName;

public class Products{

	@SerializedName("title")
	private String name;

	@SerializedName("cat_id")
	private String catId;

	@SerializedName("id")
	private String id;

	@SerializedName("image")
	private String image;

	@SerializedName("introduction")
	private String introduction;

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

	public void setIntroduction(String introduction){
		this.introduction = introduction;
	}

	public String getIntroduction(){
		return introduction;
	}

}