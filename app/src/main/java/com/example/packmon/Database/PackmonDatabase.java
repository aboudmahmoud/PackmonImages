package com.example.packmon.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.packmon.Model.Pokmen;

@Database(entities = Pokmen.class,version = 1,exportSchema = false)
public abstract class PackmonDatabase extends RoomDatabase {

    public abstract PackmonDAO packmonDAO();

}
