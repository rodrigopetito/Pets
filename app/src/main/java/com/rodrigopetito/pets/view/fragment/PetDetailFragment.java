package com.rodrigopetito.pets.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.adapter.PetDetailAdapter;
import com.rodrigopetito.pets.controller.PetsController;
import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.model.PetDetail;
import com.rodrigopetito.pets.model.PetTag;
import com.rodrigopetito.pets.util.RequestListener;
import com.rodrigopetito.pets.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetDetailFragment extends BaseFragment {

    private Long petID;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ImageView imageView;

    public void setPetID(Long petID) {
        this.petID = petID;
    }

    public static PetDetailFragment newInstance(Long petID) {
        PetDetailFragment fragment = new PetDetailFragment();
        fragment.setPetID(petID);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pet_detail, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
        getPetDetail();

    }


    private void initViews() {

        progressBar = (ProgressBar) getView().findViewById(R.id.fragment_pet_detail_progressBar);
        recyclerView = (RecyclerView) getView().findViewById(R.id.fragment_pet_detail_recyclerView);
        imageView = (ImageView) getView().findViewById(R.id.fragment_pet_detail_petImage);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);

    }


    private void getPetDetail() {

        PetsController<Pet> controller = new PetsController<>(getActivity());
        setActualController(controller);
        controller.getPetByID(new RequestListener<Pet>() {
            @Override
            public void onSuccess(Pet result) {
                PetDetailAdapter adapter = new PetDetailAdapter(getActivity(), getDetaiList(result));
                recyclerView.setAdapter(adapter);
                showList();
            }

            @Override
            public void onError(String error) {
                Util.showRestartDialog(getActivity(), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPetDetail();
                    }
                });
            }
        }, petID);


    }


    private List<PetDetail> getDetaiList(Pet pet) {

        List<PetDetail> list = new ArrayList<>();

        PetDetail detail1 = new PetDetail();
        detail1.setTitle("Pet ID");
        detail1.setDescription(pet.getId().toString());
        list.add(detail1);

        PetDetail detail2 = new PetDetail();
        detail2.setTitle("Category Name");
        detail2.setDescription(pet.getCategory().getName());
        list.add(detail2);

        for(PetTag tag : pet.getTags()) {
            PetDetail detail3 = new PetDetail();
            detail3.setTitle("Tag Name");
            detail3.setDescription(tag.getName());
            list.add(detail3);
        }

        PetDetail detail4 = new PetDetail();
        detail4.setTitle("Pet Status");
        detail4.setDescription(pet.getStatus());

        return list;

    }

    private void showList() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


}
