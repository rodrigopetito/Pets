package com.rodrigopetito.pets.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rodrigopetito.pets.controller.GenericController;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class BaseFragment extends Fragment {

    private String fragmentTitle;
    private GenericController actualController;

    public void setFragmentTitle(String title) {
        this.fragmentTitle = title;
    }

    public String getFragmentTitle() {
        return fragmentTitle;
    }

    public void setActualController(GenericController actualController) {
        this.actualController = actualController;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onPause() {
        super.onPause();
        cancelServiceCall();
    }


    private void cancelServiceCall() {
        if(this.actualController != null) {
            this.actualController.cancelServiceCall();
        }
    }

}
