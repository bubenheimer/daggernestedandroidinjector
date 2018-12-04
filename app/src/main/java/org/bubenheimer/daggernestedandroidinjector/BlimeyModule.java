/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
abstract class BlimeyModule {
    @Provides
    static @Named("blimey") String provideBlimey() {
        return "blimey";
    }
}
