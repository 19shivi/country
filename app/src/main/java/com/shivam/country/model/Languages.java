package com.shivam.country.model;

public class Languages
{

    private String name;

    private String nativeName;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setNativeName(String nativeName){
        this.nativeName = nativeName;
    }
    public String getNativeName(){
        return this.nativeName;
    }
}