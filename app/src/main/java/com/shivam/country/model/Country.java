package com.shivam.country.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.shivam.country.RoomeDatabase.Converters;

import java.util.ArrayList;
import java.util.List;
@Entity(tableName = "country_table")
public class Country {

        @PrimaryKey
        @NonNull @ColumnInfo(name = "name")
private String name;
@ColumnInfo(name="capital")
private String capital;
@ColumnInfo(name="region")
private String region;
@ColumnInfo(name="subregion")
private String subregion;
@ColumnInfo(name="population")
private int population;
@ColumnInfo(name="borders")
private ArrayList<String> borders;
@ColumnInfo(name="languages")
private ArrayList<Languages> languages;
@ColumnInfo(name="flag")
private String flag;
public void setName(String name){
    this.name = name;
        }
public String getName(){     return this.name;
        }

public void setRegion(String region){
        this.region = region;
        }
public String getRegion(){
        return this.region;
        }
public void setSubregion(String subregion){
        this.subregion = subregion;
        }
public String getSubregion(){
        return this.subregion;
        }
public void setPopulation(int population){
        this.population = population;
        }
public int getPopulation(){
        return this.population;
        }
public void setBorders(ArrayList<String> borders){
        this.borders = borders;
        }
public ArrayList<String> getBorders(){
        return this.borders;
        }
public void setLanguages(ArrayList<Languages> languages){
        this.languages = languages;
        }
public ArrayList<Languages> getLanguages(){
        return this.languages;
        }
public void setFlag(String flag){
        this.flag = flag;
        }
public String getFlag(){
        return this.flag;
        }

        public String getCapital() {
                return capital;
        }

        public void setCapital(String capital) {
                this.capital = capital;
        }
}
