package com.example.rxjavasample.chapter06.change;

import com.example.rxjavasample.utlis.LogType;
import com.example.rxjavasample.utlis.Logger;
import com.example.rxjavasample.utlis.TimeUtil;
import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample01 {

    public static void main(String[] args) {
        TimeUtil.start();

        Observable.interval(100L, TimeUnit.MILLISECONDS)
            .take(4)
            .skip(2)
            .concatMap(
                num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                    .take(10)
                    .skip(1)
                    .map(row -> num + " * " + row + " = " + num * row)
            )
            .subscribe(
                data -> Logger.log(LogType.ON_NEXT, data),
                error -> {},
                () -> {
                    TimeUtil.end();
                    TimeUtil.takeTime();
                }
            );

        TimeUtil.sleep(5000L);
    }

}
