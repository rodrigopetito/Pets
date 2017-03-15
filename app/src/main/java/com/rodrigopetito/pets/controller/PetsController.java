package com.rodrigopetito.pets.controller;

import android.content.Context;

import com.rodrigopetito.pets.dao.PetDAO;
import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.util.RequestListener;

import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetsController<T> extends GenericController<PetDAO<T>> {

    public PetsController(Context context) {
        super(context);
    }

    @Override
    protected PetDAO<T> setDAO() {
        return new PetDAO<T>(getContext());
    }

    public void getPetsList(final RequestListener<T> requestListener) {

        getDao().setRequestListener(new RequestListener<T>() {
            @Override
            public void onSuccess(T result) {
                requestListener.onSuccess(result);
            }

            @Override
            public void onError(String error) {
                requestListener.onError(error);
            }
        });
        getDao().getPetsList("available");

    }


    public void getPetByID(final RequestListener<T> requestListener, Long petID) {

        getDao().setRequestListener(new RequestListener<T>() {
            @Override
            public void onSuccess(T result) {
                requestListener.onSuccess(result);
            }

            @Override
            public void onError(String error) {
                requestListener.onError(error);
            }
        });
        getDao().getPetByID(petID);

    }


}
