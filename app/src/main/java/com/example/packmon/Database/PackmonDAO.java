package com.example.packmon.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.packmon.Model.Pokmen;

import java.util.List;

@Dao
public interface PackmonDAO {
    @Insert
    public void insertPackmoen(Pokmen pokmen);


    @Delete
    public void DeletePackmoen(Pokmen pokmen);

    @Query("Select * from PokmenFave")
    public LiveData<List<Pokmen>> getPakmones();
}
