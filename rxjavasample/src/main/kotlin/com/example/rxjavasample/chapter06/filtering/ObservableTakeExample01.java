package com.example.rxjavasample.chapter06.filtering;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableTakeExample01 {

    public static void main(String[] args) {
        Observable.just("a", "b", "c", "d")
            .take(2)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}
