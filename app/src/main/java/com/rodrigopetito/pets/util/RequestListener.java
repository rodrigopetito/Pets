package com.rodrigopetito.pets.util;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public interface RequestListener<T> {

    void onSuccess(T result);
    void onError(String error);
}
