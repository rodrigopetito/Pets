package com.rodrigopetito.pets.dao;

import android.content.Context;

import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.util.RequestListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetDAO<T> extends GenericDAO<T> {

    public PetDAO(Context context) {
        super(context);
    }

    public void getPetsList(String status) {
        callService(getRetrofit().create(PetREST.class).getPetsList(status));
    }

    public void getPetByID(Long petID) {
        callService(getRetrofit().create(PetREST.class).getPetByID(petID));
    }


    private interface PetREST {

        @GET("pet/findByStatus")
        Call<List<Pet>> getPetsList(@Query("status") String status);

        @GET("pet/{id}")
        Call<Pet> getPetByID(@Path("id") Long id);
    }

}
