/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.support.DaggerAppCompatActivity;

public class NestedActivity extends DaggerAppCompatActivity {
    private static final String TAG = NestedActivity.class.getSimpleName();

    @Inject
    @Named("blarney") String blarney;
    //should fail
//    @Inject
//    @Named("blimey") String blimey;
    @Inject
    @Named("barney") String barney;
    @Inject
    @Named("buyme") String buyme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested);

        Log.i(TAG, blarney);
        Log.i(TAG, barney);
        Log.i(TAG, buyme);
    }

    @Override
    public void finish() {
        super.finish();

        ((App) getApplication()).clearSessionComponent();
    }
}
