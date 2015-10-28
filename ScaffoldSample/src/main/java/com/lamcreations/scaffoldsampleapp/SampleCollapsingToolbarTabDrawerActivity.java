package com.lamcreations.scaffoldsampleapp;


import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lamcreations.scaffold.common.activities.CollapsingToolbarTabDrawerActivity;


public class SampleCollapsingToolbarTabDrawerActivity extends CollapsingToolbarTabDrawerActivity {

    @Override
    protected Fragment getLeftStartDrawerFragment() {
        return new SampleNavigationDrawerFragment();
    }

    @Override
    protected Fragment getRightEndDrawerFragment() {
        return null;
    }

    @Override
    protected void setupCollapsingToolbarLayout() {
        super.setupCollapsingToolbarLayout();
        mCollapsingToolbarLayout.setTitle("North America");
        mCollapsingToolbarLayout.setContentScrimResource(R.color.primary);
    }

    @Override
    protected void setupCollapsingToolbarLayoutBackdrop() {
        super.setupCollapsingToolbarLayoutBackdrop();
        Glide.with(this).load(R.drawable.north_america).into((ImageView)mCollapsingToolbarLayoutBackdropView);
    }

    @Override
    protected int getCollapsingToolbarMaxHeight() {
        return getResources().getDimensionPixelSize(R.dimen.collapsing_toolbar_height);
    }

    @Override
    protected int getCollapsingToolbarLayoutBackdropResId() {
        return R.layout.image_view;
    }

    @Override
    protected float getParallaxMultiplier() {
        return 0.5f;
    }

    @Override
    protected int getFabAnchorId() {
        return R.id.scaffold_content;
    }

    @Override
    protected boolean setupFab() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mContentView, "Do Something Awesome!", Snackbar.LENGTH_SHORT).show();
            }
        });
        return true;
    }

    @Override
    protected void onUpNavigation() {
        ActivityCompat.finishAfterTransition(this);
    }

    @Override
    protected int getTabMode() {
        return TabLayout.MODE_SCROLLABLE;
    }

    @Override
    protected PagerAdapter getPagerAdapter() {
        return new SampleTabPagerAdapter(getSupportFragmentManager());
    }

    @Override
    protected int getInitialTabPosition() {
        return 0;
    }
}
