/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = SessionComponent.class)
abstract class AppModule {
    @Provides
    static @Named("blarney") String provideBlarney() {
        return "blarney";
    }
}
