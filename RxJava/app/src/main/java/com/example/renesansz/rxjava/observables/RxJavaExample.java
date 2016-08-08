package com.example.renesansz.rxjava.observables;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;

public class RxJavaExample {

    public static void main(String[] args) {
        final List<String> list = Arrays.asList("Android", "Ubuntu", "Mac OSX");

        Observable<List<String>> listObservable = Observable.just(list);

        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<String> strings) {
                Log.d("RxJava", String.valueOf(list));
            }
        });
    }

}
