package com.rodrigopetito.pets.controller;

import android.content.Context;

import com.rodrigopetito.pets.dao.GenericDAO;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public abstract class GenericController<T extends GenericDAO> {

    protected abstract T setDAO();

    private Context context;
    private T dao;

    public GenericController(Context context) {
        this.context = context;
        this.dao = setDAO();
    }

    public Context getContext() {
        return context;
    }

    public T getDao() {
        return dao;
    }


    public void cancelServiceCall() {
        this.dao.cancelServiceCall();
    }


}
