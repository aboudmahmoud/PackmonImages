package com.example.packmon.diRetrofit;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.packmon.Database.PackmonDAO;
import com.example.packmon.Database.PackmonDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabseModule {
    @Provides
    @Singleton
    public  static PackmonDatabase packmonDatabase(Application application)
    {
        return Room.databaseBuilder(application,PackmonDatabase.class,"PokmenFave")
                .fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    public static PackmonDAO ProvideDao(PackmonDatabase packmonDatabase)
    {
        return packmonDatabase.packmonDAO();
    }
}
