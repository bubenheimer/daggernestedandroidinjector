/*
 * Copyright (c) 2015-2016 Uli Bubenheimer. All rights reserved.
 */

package org.bubenheimer.daggernestedandroidinjector;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;

final class ComboDispatchingAndroidInjector<T> implements AndroidInjector<T> {
    private final DispatchingAndroidInjector<T>[] injectors;

    @SafeVarargs
    ComboDispatchingAndroidInjector(final DispatchingAndroidInjector<T>... injectors) {
        this.injectors = injectors;
    }

    @Override
    public void inject(final T instance) {
        for (final DispatchingAndroidInjector<T> injector : injectors) {
            final boolean success = injector.maybeInject(instance);
            if (success) {
                return;
            }
        }

        throw new IllegalArgumentException(
                "No valid injection for " + instance.getClass().getName());
    }
}
