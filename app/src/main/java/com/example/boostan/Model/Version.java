package com.example.boostan.Model;

import com.google.gson.annotations.SerializedName;

public class Version{

	@SerializedName("id")
	private int id;

	@SerializedName("version")
	private String version;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}
}