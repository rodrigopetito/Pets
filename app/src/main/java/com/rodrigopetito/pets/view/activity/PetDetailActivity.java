package com.rodrigopetito.pets.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TableLayout;

import com.rodrigopetito.pets.R;
import com.rodrigopetito.pets.adapter.ViewPagerAdapter;
import com.rodrigopetito.pets.util.StringUtil;
import com.rodrigopetito.pets.view.fragment.CustomFragment;
import com.rodrigopetito.pets.view.fragment.PetDetailFragment;

/**
 * Created by rodrigopetito on 3/15/17.
 */

public class PetDetailActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Long petID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_detail);

        petID = getIntent().getLongExtra(StringUtil.PET_ID_INTENT, -1);

        initViews();
        setupViewPager();

    }


    private void initViews() {
        tabLayout = (TabLayout) findViewById(R.id.activity_pet_detail_tabLayout);
        viewPager = (ViewPager) findViewById(R.id.activity_pet_detail_viewPager);
    }


    private void setupViewPager() {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        PetDetailFragment petDetailFragment = PetDetailFragment.newInstance(petID);
        petDetailFragment.setFragmentTitle("Detalle Pet");

        CustomFragment customFragment = new CustomFragment();
        customFragment.setFragmentTitle("Fragment");

        adapter.addFragment(petDetailFragment);
        adapter.addFragment(customFragment);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }



}
