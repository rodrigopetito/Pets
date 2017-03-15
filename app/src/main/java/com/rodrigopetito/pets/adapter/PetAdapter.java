package com.rodrigopetito.pets.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.model.Pet;
import com.rodrigopetito.pets.util.ListItemClickListener;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetHolder> {

    private Context context;
    private List<Pet> petList;
    private ListItemClickListener<Pet> listItemClickListener;

    public PetAdapter(Context context, List<Pet> petList) {
        this.context = context;
        this.petList = petList;
    }

    public void setListItemClickListener(ListItemClickListener<Pet> listItemClickListener) {
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public PetHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_pet, parent, false);
        PetHolder holder = new PetHolder(v);
        v.setOnClickListener(holder);
        return holder;

    }

    @Override
    public void onBindViewHolder(PetHolder holder, int position) {
        holder.petName.setText(petList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return petList.size();
    }



    public class PetHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView petName;

        public PetHolder(View itemView) {
            super(itemView);

            petName = (TextView) itemView.findViewById(R.id.adapter_pet_petName);
        }

        @Override
        public void onClick(View v) {
            listItemClickListener.onItemClick(petList.get(getAdapterPosition()), getAdapterPosition());
        }

    }



}
