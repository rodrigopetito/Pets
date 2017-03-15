package com.rodrigopetito.pets.view.activity;

import android.support.v7.app.AppCompatActivity;

import com.rodrigopetito.pets.controller.GenericController;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class BaseActivity extends AppCompatActivity {

    private GenericController actualController;


    public void setActualController(GenericController actualController) {
        this.actualController = actualController;
    }

    @Override
    protected void onPause() {
        super.onPause();
        cancelServiceCall();
    }


    private void cancelServiceCall() {
        if(this.actualController != null) {
            this.actualController.cancelServiceCall();
        }
    }


}
