package com.example.packmon.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PokmenFave")
public class Pokmen {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String name;
    private String url;

    public Pokmen(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
