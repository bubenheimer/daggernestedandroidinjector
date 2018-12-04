/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import android.app.Activity;
import android.app.Service;

import androidx.fragment.app.Fragment;
import dagger.Subcomponent;
import dagger.android.DispatchingAndroidInjector;

@Subcomponent(modules = {
        BarneyModule.class,
        NestedActivityComponentModule.class
})
interface SessionComponent {
    DispatchingAndroidInjector<Activity> activityInjector();
    DispatchingAndroidInjector<Fragment> fragmentInjector();
    DispatchingAndroidInjector<Service> serviceInjector();

    @Subcomponent.Builder
    interface Builder {
        SessionComponent create();
    }
}
