package com.example.packmon.Reprostory;

import androidx.lifecycle.LiveData;

import com.example.packmon.Database.PackmonDAO;
import com.example.packmon.Model.PakmonResponse;
import com.example.packmon.Model.Pokmen;
import com.example.packmon.Network.PackmonApiServies;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repostory {

    private PackmonApiServies packmonApiServies;
    private  PackmonDAO packmonDAO;
    @Inject
    public Repostory(PackmonApiServies packmonApiServies , PackmonDAO packmonDAO) {
        this.packmonApiServies = packmonApiServies;
        this.packmonDAO=packmonDAO;
    }

    public Observable<PakmonResponse> getPackmon()
    {
        return packmonApiServies.getPakmones();
    }
    public void InsertPakmon(Pokmen pokmen){
        packmonDAO.insertPackmoen(pokmen);
    }

    public void DeletePokmon(Pokmen pokmen)
    {
        packmonDAO.DeletePackmoen(pokmen);
    }

    public LiveData<List<Pokmen>> getFavePackmont()
    {
        return packmonDAO.getPakmones();
    }
}
