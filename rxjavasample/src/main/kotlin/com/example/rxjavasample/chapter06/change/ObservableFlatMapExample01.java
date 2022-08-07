package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableFlatMapExample01 {

    public static void main(String[] args) {
        Observable.just("Hello")
            .flatMap(
                hello -> Observable.just("자바", "파이썬", "안드로이드").map(lang -> hello + ", " + lang))
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}
