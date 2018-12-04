/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import javax.inject.Inject;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;

public final class App extends Application implements
        HasActivityInjector,
        HasSupportFragmentInjector,
        HasServiceInjector {

    @Inject
    SessionComponent.Builder sessionCompBuilder;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceInjector;

    private @Nullable AndroidInjector<Activity> comboActivityInjector;
    private @Nullable AndroidInjector<Fragment> comboFragmentInjector;
    private @Nullable AndroidInjector<Service> comboServiceInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.create().inject(this);
    }

    @MainThread
    void createSessionComponent() {
        final SessionComponent sessionComp = sessionCompBuilder.create();

        comboActivityInjector = new ComboDispatchingAndroidInjector<>(
                activityInjector, sessionComp.activityInjector());
        comboFragmentInjector = new ComboDispatchingAndroidInjector<>(
                fragmentInjector, sessionComp.fragmentInjector());
        comboServiceInjector = new ComboDispatchingAndroidInjector<>(
                serviceInjector, sessionComp.serviceInjector());
    }

    @MainThread
    void clearSessionComponent() {
        comboActivityInjector = null;
        comboFragmentInjector = null;
        comboServiceInjector = null;
    }

    @MainThread
    @Override
    public AndroidInjector<Activity> activityInjector() {
        final AndroidInjector<Activity> comboInjector = comboActivityInjector;
        return comboInjector == null ? activityInjector : comboInjector;
    }

    @MainThread
    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        final AndroidInjector<Fragment> comboInjector = comboFragmentInjector;
        return comboInjector == null ? fragmentInjector : comboInjector;
    }

    @MainThread
    @Override
    public AndroidInjector<Service> serviceInjector() {
        final AndroidInjector<Service> comboInjector = comboServiceInjector;
        return comboInjector == null ? serviceInjector : comboInjector;
    }
}
