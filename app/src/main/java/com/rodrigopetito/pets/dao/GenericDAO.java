package com.rodrigopetito.pets.dao;

import android.content.Context;
import android.widget.Toast;

import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.util.RequestListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class GenericDAO<T> implements Callback {

    private Context context;
    private Retrofit retrofit;
    private RequestListener requestListener;
    private Call serviceCall;

    public GenericDAO(Context context) {
        this.context = context;
        this.retrofit = new Retrofit.Builder()
                .baseUrl(context.getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Context getContext() {
        return context;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


    @Override
    public void onResponse(Call call, Response response) {
        if(requestListener != null) {
            requestListener.onSuccess(response.body());
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        if(requestListener != null) {
            requestListener.onError(t.getMessage());
        }
    }

    protected void callService(Call servicCall) {
        this.serviceCall = servicCall;
        this.serviceCall.enqueue(this);
    }

    public void setRequestListener(RequestListener<T> requestListener) {
        this.requestListener = requestListener;
    }

    public void cancelServiceCall() {
        if(this.serviceCall != null && isBeingExecuted()) {
            this.serviceCall.cancel();
        }
    }

    private Boolean isBeingExecuted() {
        return this.serviceCall != null && this.serviceCall.isExecuted();
    }


}
