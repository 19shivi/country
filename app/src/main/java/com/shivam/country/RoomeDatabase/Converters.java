package com.shivam.country.RoomeDatabase;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shivam.country.model.Languages;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

        @TypeConverter
        public static ArrayList<String> tobordersArrayList(String value) {
            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public static String frombordersArrayList(ArrayList<String> list) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            return json;
        }
    @TypeConverter
    public static ArrayList<Languages> tolanguagesArrayList(String value) {
        Type listType = new TypeToken<ArrayList<Languages>>() {}.getType();
        return new Gson().fromJson(String.valueOf(value), listType);
    }

    @TypeConverter
    public static String fromlanguagesArrayList(ArrayList<Languages> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

}
