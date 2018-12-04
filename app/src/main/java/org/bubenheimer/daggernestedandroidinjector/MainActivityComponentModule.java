/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class MainActivityComponentModule {
    @ContributesAndroidInjector(modules = BlimeyModule.class)
    abstract MainActivity contributeMainActivityInjector();
}
