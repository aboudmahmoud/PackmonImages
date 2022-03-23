package com.example.packmon.Network;

import com.example.packmon.Model.PakmonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PackmonApiServies {
    @GET("pokemon")
    Observable<PakmonResponse> getPakmones();
}
