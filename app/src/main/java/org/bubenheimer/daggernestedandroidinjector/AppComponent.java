/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        MainActivityComponentModule.class
})
interface AppComponent extends AndroidInjector<App> {
}
