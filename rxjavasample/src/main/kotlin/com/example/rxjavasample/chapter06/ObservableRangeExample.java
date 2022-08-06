package com.example.rxjavasample.chapter06;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import io.reactivex.rxjava3.core.Observable;

public class ObservableRangeExample {

    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(0, 5);
        source.subscribe(num -> Logger.log(LogType.ON_NEXT, num));
    }

}
