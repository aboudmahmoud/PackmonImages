package com.example.packmon.Reprostory;

import com.example.packmon.Model.PakmonResponse;
import com.example.packmon.Network.PackmonApiServies;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repostory {

    private PackmonApiServies packmonApiServies;

    @Inject
    public Repostory(PackmonApiServies packmonApiServies) {
        this.packmonApiServies = packmonApiServies;
    }

    public Observable<PakmonResponse> getPackmon()
    {
        return packmonApiServies.getPakmones();
    }
}
