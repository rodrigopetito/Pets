package com.rodrigopetito.pets.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.model.PetDetail;

import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetDetailAdapter extends RecyclerView.Adapter<PetDetailAdapter.PetDetailHolder> {

    private Context context;
    private List<PetDetail> petDetailList;

    public PetDetailAdapter(Context context, List<PetDetail> pet) {
        this.context = context;
        this.petDetailList = pet;
    }

    @Override
    public PetDetailAdapter.PetDetailHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_pet_detail, parent, false);
        return new PetDetailHolder(v);
    }

    @Override
    public void onBindViewHolder(PetDetailAdapter.PetDetailHolder holder, int position) {
        holder.title.setText(petDetailList.get(position).getTitle());
        holder.description.setText(petDetailList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return petDetailList.size();
    }


    public class PetDetailHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView description;

        public PetDetailHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.adapter_pet_detail_title);
            description = (TextView) itemView.findViewById(R.id.adapter_pet_detail_description);
        }

    }



}
