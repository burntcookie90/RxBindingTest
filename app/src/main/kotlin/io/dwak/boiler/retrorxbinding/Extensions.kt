package io.dwak.boiler.retrorxbinding

import android.app.Activity
import android.support.v4.app.Fragment
import rx.Observable
import rx.functions.Action1

public fun Activity.bind<T>(from: Observable<T>, to: Action1<in T>) {
    from.subscribe(Action1 { to.call(it) })
}

public fun Fragment.bind<T>(from: Observable<T>, to: Action1<in T>) {
    from.subscribe(Action1 { to.call(it) })
}

