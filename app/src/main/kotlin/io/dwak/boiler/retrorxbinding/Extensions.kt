package io.dwak.boiler.retrorxbinding

import android.content.Context
import rx.Observable
import rx.functions.Action1

public fun Context.bind<T>(from: Observable<T>, to: Action1<in T>) {
    from.subscribe(Action1 { to.call(it) })
}

public fun <T> Observable<T>.bind(action: Action1<in T>){
    subscribe(action);
}
