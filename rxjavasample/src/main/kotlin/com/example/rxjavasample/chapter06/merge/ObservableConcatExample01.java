package com.example.rxjavasample.chapter06.merge;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableConcatExample01 {

    public static void main(String[] args) {
        Observable<Long> observable1 = Observable.interval(500L, TimeUnit.MILLISECONDS)
            .take(4);
        Observable<Long> observable2 = Observable.interval(300L, TimeUnit.MILLISECONDS)
            .take(5)
            .map(num -> num + 1000);

        Observable.concat(observable1, observable2)
            .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(3500L);
    }

}
