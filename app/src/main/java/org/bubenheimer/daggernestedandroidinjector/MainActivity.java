/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    @Named("blarney") String blarney;
    @Inject
    @Named("blimey") String blimey;
    //should fail
//    @Inject
//    @Named("barney") String barney;
    //should fail
//    @Inject
//    @Named("buyme") String buyme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, blarney);
        Log.i(TAG, blimey);
    }

    public void onClick(final View view) {
        ((App) getApplication()).createSessionComponent();
        startActivity(new Intent(this, NestedActivity.class));
    }
}
