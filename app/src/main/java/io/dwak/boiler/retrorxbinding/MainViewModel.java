package io.dwak.boiler.retrorxbinding;

import rx.Observable;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class MainViewModel {

    private int mCounter = 0;
    private BehaviorSubject<Integer> mCounterSubject = BehaviorSubject.create();
    private BehaviorSubject<Integer> mProgressSubject = BehaviorSubject.create();

    public Action1<Object> counterClicked(){
        return object -> mCounterSubject.onNext(mCounter++);
    }

    public Observable<Integer> counter(){
        return mCounterSubject.asObservable();
    }

    public Action1<Integer> seekProgress(){
        return mProgressSubject::onNext;
    }

    public Observable<Integer> progress(){
        return mProgressSubject.asObservable();
    }
}
