package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableFlatMapExample02 {

    public static void main(String[] args) {
        Observable.range(2, 1)
            .flatMap(
                num -> Observable.range(1, 9).map(row -> num + " * " + row + " = " + num * row)
            )
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }

}
