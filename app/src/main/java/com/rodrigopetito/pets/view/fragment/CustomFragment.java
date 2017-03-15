package com.rodrigopetito.pets.view.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewAnimator;

import com.rodrigopetito.pets.R;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class CustomFragment extends BaseFragment implements Animator.AnimatorListener {

    private View oneView;
    private View anotherView;
    private Button startButton;

    private AnimatorSet scaleDownSet;
    private AnimatorSet scaleUpSet;
    private AnimatorSet currentAnimation;
    private Boolean scaleDown;
    private Boolean isPlaying;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_custom, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        oneView = view.findViewById(R.id.fragment_custom_oneView);
        anotherView = view.findViewById(R.id.fragment_custom_anotherView);
        startButton = (Button) view.findViewById(R.id.fragment_custom_startButton);

        scaleDown = true;
        isPlaying = false;


        scaleDownSet = new AnimatorSet();
        scaleDownSet.playSequentially
                (getScaleAnimator(anotherView, 1f, 0f),
                        getScaleAnimator(oneView, 1f, 0f));


        scaleUpSet = new AnimatorSet();
        scaleUpSet.playSequentially
                (getScaleAnimator(oneView, 0f, 1f),
                        getScaleAnimator(anotherView, 0f, 1f));


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPlaying) {
                    currentAnimation = getAnimatorToPlay();
                    currentAnimation.start();
                } else {
                    currentAnimation.removeAllListeners();
                }
                isPlaying = !isPlaying;
            }
        });

    }


    private ObjectAnimator getScaleAnimator(View target, Float from, Float to) {
        ObjectAnimator scale = ObjectAnimator.ofFloat(target, View.SCALE_Y, from, to);
        return scale;
    }

    private AnimatorSet getAnimatorToPlay() {
        AnimatorSet animatorSet;
        if(scaleDown) {
            animatorSet = scaleDownSet;
        } else {
            animatorSet = scaleUpSet;
        }
        animatorSet.removeAllListeners();
        animatorSet.addListener(CustomFragment.this);
        scaleDown = !scaleDown;
        return  animatorSet;
    }


    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        currentAnimation = getAnimatorToPlay();
        currentAnimation.start();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
