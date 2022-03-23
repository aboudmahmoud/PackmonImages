package com.example.packmon.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.packmon.Model.PakmonResponse;
import com.example.packmon.Model.Pokmen;
import com.example.packmon.Reprostory.Repostory;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class PackmenoViewModel extends ViewModel {

    private Repostory repostory;
    MutableLiveData<ArrayList<Pokmen>> PokmenList = new MutableLiveData<>();

    @Inject
    public PackmenoViewModel(Repostory repostory) {
        this.repostory = repostory;
    }

    public MutableLiveData<ArrayList<Pokmen>> getPokmenList() {
        return PokmenList;
    }

    public void getPackmoens() {
        repostory.getPackmon().subscribeOn(Schedulers.io())
                .map(new Function<PakmonResponse, ArrayList<Pokmen>>() {

                    @Override
                    public ArrayList<Pokmen> apply(PakmonResponse pakmonResponse) throws Throwable {
                        ArrayList<Pokmen> list = pakmonResponse.getResults();
                        for (Pokmen pokmen :list)
                        {
                            String url=pokmen.getUrl();
                            String[] pokmentIndex=url.split("/");
                            pokmen.setUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                                    +pokmentIndex[pokmentIndex.length-1]+".png");

                        }
                        return list;
                    }

                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(pokmen -> PokmenList.setValue(pokmen)
                        ,throwable -> Log.d("Aboud", "View model getPackmoens: "+throwable.getMessage()));
    }
}
